package codegen;

import org.objectweb.asm.Opcodes;
import syntaxtree.Method;
import syntaxtree.expressions.LocalOrFieldVarExpr;
import syntaxtree.statementexpressions.*;

import static codegen.ClassGenerator.constructorDescriptor;
import static codegen.ClassGenerator.methodDescriptor;
import static codegen.ClassGenerator.fieldDescriptor;
import static codegen.ExpressionGenerator.genExpr;


public class StatementExpressionGenerator {
    public static void genStmtExpr(StatementExpression stx, Method m) {
        switch (stx){
            case null:
                break;
            case AssignStmtExpr s:
                genAssign(s, m);
                break;
            case MethodCallStmtExpr s:
                genMethodCall(s, m);
                break;
            case NewStmtExpr s:
                genNew(s, m);
                break;
        }
    }

    public static void genAssign(AssignStmtExpr s, Method m) {
        String type = s.as2Expr.type.name;

        if (s.as2Expr instanceof LocalOrFieldVarExpr var) {
            switch (var.context) {
                case local -> {
                    int index = m.localVariableIndexes.get(var.name);
                    genExpr(s.asFromExpr, m);
                    switch (type) {
                        case "int", "char", "boolean" -> {
                            m.visitor.visitVarInsn(Opcodes.ISTORE, index);
                        }
                        case default -> {
                            m.visitor.visitVarInsn(Opcodes.ASTORE, index);
                        }
                    }
                    break;
                }
                case field -> {
                    m.visitor.visitVarInsn(Opcodes.ALOAD, 0);
                    genExpr(s.asFromExpr, m);
                    m.visitor.visitFieldInsn(Opcodes.PUTFIELD, m.ownerClass.name, var.name, fieldDescriptor(var.type.name));
                    break;
                }
                case unknown -> {
                    throw new IllegalStateException("variable unknown");
                }
            }
        } else {
            throw new IllegalStateException("cannot assign to anything other than LocalOrFieldVarExpr: " + s.as2Expr);
        }
    }

    public static void genNew(NewStmtExpr s, Method m) {
        // new Klasse
        m.visitor.visitTypeInsn(Opcodes.NEW, s.type.name);
        // dup
        m.visitor.visitInsn(Opcodes.DUP);
        //gen params
        s.initParams.forEach(e -> genExpr(e, m));
        // invokespecial Konstruktor
        String paramDesc = s.initParams.stream().map(e -> fieldDescriptor(e.type.name)).reduce("", String::concat);
        m.visitor.visitMethodInsn(Opcodes.INVOKESPECIAL, s.type.name, "<init>", "("+paramDesc+")V", false);
    }

    public static void genMethodCall(MethodCallStmtExpr mcall, Method m) {
        genExpr(mcall.obj, m);
        mcall.methParams.forEach(e -> genExpr(e, m));
        m.visitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, mcall.obj.type.name, mcall.meth, methodDescriptor(m), false);
    }
}
