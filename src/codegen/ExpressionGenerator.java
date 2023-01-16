package codegen;

import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import syntaxtree.Method;
import syntaxtree.expressions.*;
import syntaxtree.statements.IfStmt;

import static codegen.StatementExpressionGenerator.genStmtExpr;
import static codegen.StatementGenerator.*;
import static codegen.ClassGenerator.fieldDescriptor;


public class ExpressionGenerator {
    public static void genExpr(Expression exp, Method m)
    {
        switch (exp) {
            case IntegerExpr e:
                switch (e.i) {
                    case -1 -> m.visitor.visitInsn(Opcodes.ICONST_M1);
                    case 0 -> m.visitor.visitInsn(Opcodes.ICONST_0);
                    case 1 -> m.visitor.visitInsn(Opcodes.ICONST_1);
                    case 2 -> m.visitor.visitInsn(Opcodes.ICONST_2);
                    case 3 -> m.visitor.visitInsn(Opcodes.ICONST_3);
                    case 4 -> m.visitor.visitInsn(Opcodes.ICONST_4);
                    case 5 -> m.visitor.visitInsn(Opcodes.ICONST_5);
                    default -> m.visitor.visitLdcInsn(e.i);
                }
                break;
            case CharExpr e:
                m.visitor.visitLdcInsn(e);
                break;
            case BoolExpr e:
                if (e.b) { m.visitor.visitInsn(Opcodes.ICONST_1); }
                else { m.visitor.visitInsn(Opcodes.ICONST_0); }
                break;
            case StringExpr e:
                m.visitor.visitLdcInsn(e.s);
                break;
            case JNullExpr e:
                m.visitor.visitInsn(Opcodes.ACONST_NULL);
                break;
            case LocalOrFieldVarExpr e:
                genLocalOrFieldVarExpr(e, m);
                break;
            case InstVarExpr e:
                //TODO
                break;
            case BinaryExpr e:
                genBinaryExpr(e, m);
                break;
            case UnaryExpr e:
                genUnaryExpr(e, m);
                break;
            case ThisExpr e:
                m.visitor.visitVarInsn(Opcodes.ALOAD, 0);
                break;
            case SuperExpr e:
                //TODO
                break;
            case StmtExprExpr e:
                genStmtExpr(e.stmtExprExpr, m);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + exp);
        }
    }

    private static void genBinaryExpr(BinaryExpr expr, Method m) {
        String type = "int"; //TODO: get type from expr
        switch (type){
            case "int", "char":
                switch (expr.eval) {
                    case "+" -> {
                        genExpr(expr.expr1, m);
                        genExpr(expr.expr2, m);
                        m.visitor.visitInsn(Opcodes.IADD);
                    }
                    case "-" -> {
                        genExpr(expr.expr1, m);
                        genExpr(expr.expr2, m);
                        m.visitor.visitInsn(Opcodes.ISUB);
                    }
                    case "*" -> {
                        genExpr(expr.expr1, m);
                        genExpr(expr.expr2, m);
                        m.visitor.visitInsn(Opcodes.IMUL);
                    }
                    case "/" -> {
                        genExpr(expr.expr1, m);
                        genExpr(expr.expr2, m);
                        m.visitor.visitInsn(Opcodes.IDIV);
                    }
                }
                break;
            case "boolean":
                switch (expr.eval) {
                    case "and","&&" -> {
                        genExpr(expr.expr1, m);
                        genExpr(expr.expr2, m);
                        m.visitor.visitInsn(Opcodes.IAND);
                    }
                    case "or","||" -> {
                        genExpr(expr.expr1, m);
                        genExpr(expr.expr2, m);
                        m.visitor.visitInsn(Opcodes.IOR);
                    }
                }
                break;
            case "String":
                // TODO
                /*switch (expr.eval){
                    case "+":
                        genExpr(expr.expr1, mv);
                        genExpr(expr.expr2, mv);
                        mv.visitMethodInsn(
                                Opcodes.INVOKEDYNAMIC,
                                "this",
                                "makeConcatWithConstants",
                                "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;",
                                false);
                        break;
                }*/
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }
    }

    private static void genUnaryExpr(UnaryExpr expr, Method m){
        switch (expr.eval){
            case "-":
                genExpr(expr.expr, m);
                m.visitor.visitInsn(Opcodes.INEG);
                break;
            case "not","!":
                Label retzero = new Label();
                Label end = new Label();

                genExpr(expr.expr, m);

                m.visitor.visitJumpInsn(Opcodes.IFNE, retzero);
                m.visitor.visitInsn(Opcodes.ICONST_1);
                m.visitor.visitJumpInsn(Opcodes.GOTO, end);

                m.visitor.visitLabel(retzero);
                m.visitor.visitInsn(Opcodes.ICONST_0);

                m.visitor.visitLabel(end);
                break;
        }
    }


    private static void genLocalOrFieldVarExpr(LocalOrFieldVarExpr var, Method m) {
        String type = "asdf"; //TODO: get type from expression

        //TODO:
        // look for variable names in parameters, locals and fields
        // a name cannot occur both in locals and parameters!
        // this means, that the method at hand has to know about the fields of the class, the method parameters and the local variables
    }

    private static void genLocalVar(LocalVar v, Method m) {
        String type = "int"; //TODO get type from expression
        int index = m.localVariableIndexes.get(v.name);

        switch (type) {
            case "int", "char", "boolean" -> {
                m.visitor.visitVarInsn(Opcodes.ILOAD, index);
            }
            case default -> {
                m.visitor.visitVarInsn(Opcodes.ALOAD, index);
            }
        }

    }

    private static void genFieldVar(FieldVar f, Method m) {
        String type = "int"; //TODO get type from expression

        //m.visitor.visitFieldInsn(Opcodes.GETFIELD, f.owner, f.name, fieldDescriptor(f.type));
    }

}
