package codegen;

import org.objectweb.asm.Opcodes;
import syntaxtree.Method;
import syntaxtree.expressions.FieldVar;
import syntaxtree.expressions.LocalVar;
import syntaxtree.statementexpressions.*;

import static codegen.ClassGenerator.methodDescriptor;
import static codegen.ExpressionGenerator.genExpr;


public class StatementExpressionGenerator {
    public static void genStmtExpr(StatementExpression stx, Method m) {
        switch (stx){
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
        genExpr(s.asFromExpr, m);

        switch (s.as2Expr) {
            case LocalVar var:
                String type = "int"; //TODO get type from expression

                int index = m.localVariableIndexes.get(var.name);

                switch (type) {
                    case "int", "char", "boolean" -> {
                        m.visitor.visitVarInsn(Opcodes.ISTORE, index);
                    }
                    case default -> {
                        m.visitor.visitVarInsn(Opcodes.ASTORE, index);
                    }
                }

                break;
            case FieldVar field:
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + s.as2Expr);
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
        m.visitor.visitMethodInsn(Opcodes.INVOKESPECIAL, s.type.name, "<init>", methodDescriptor(m), false);
    }

    public static void genMethodCall(MethodCallStmtExpr mcall, Method m) {
        mcall.methParams.forEach(e -> genExpr(e, m));
        //m.visitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, mcall.obj.type, mcall.meth, methodDescriptor(m), false);
    }
}
