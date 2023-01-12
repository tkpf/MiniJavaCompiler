package codegen;

import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import syntaxtree.expressions.*;
import syntaxtree.statements.IfStmt;

public class ExpressionGenerator {
    public static void genExpr(Expression exp, MethodVisitor mv)
    {
        switch (exp) {
            case IntegerExpr e:
                switch (e.i) {
                    case -1 -> mv.visitInsn(Opcodes.ICONST_M1);
                    case 0 -> mv.visitInsn(Opcodes.ICONST_0);
                    case 1 -> mv.visitInsn(Opcodes.ICONST_1);
                    case 2 -> mv.visitInsn(Opcodes.ICONST_2);
                    case 3 -> mv.visitInsn(Opcodes.ICONST_3);
                    case 4 -> mv.visitInsn(Opcodes.ICONST_4);
                    case 5 -> mv.visitInsn(Opcodes.ICONST_5);
                    default -> mv.visitLdcInsn(e.i);
                }
                break;
            case CharExpr e:
                mv.visitLdcInsn(e);
                break;
            case BoolExpr e:
                if (e.b) { mv.visitInsn(Opcodes.ICONST_1); }
                else { mv.visitInsn(Opcodes.ICONST_0); }
                break;
            case StringExpr e:
                mv.visitLdcInsn(e.s);
                break;
            case JNullExpr e:
                mv.visitInsn(Opcodes.ACONST_NULL);
                break;
            case LocalOrFieldVarExpr e:
                genLocalOrFieldVarExpr(e, mv);
                break;
            case InstVarExpr e:
                //TODO
                break;
            case BinaryExpr e:
                genBinaryExpr(e, mv);
                break;
            case UnaryExpr e:
                genUnaryExpr(e, mv);
                break;
            case ThisExpr e:
                mv.visitVarInsn(Opcodes.ALOAD, 0);
                break;
            case SuperExpr e:
                //TODO
                break;
            case StmtExprExpr e:
                //TODO
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + exp);
        }
    }

    private static void genBinaryExpr(BinaryExpr expr, MethodVisitor mv) {
        String type = "int"; //TODO: get type from expr
        switch (type){
            case "int", "char":
                switch (expr.eval) {
                    case "+" -> {
                        genExpr(expr.expr1, mv);
                        genExpr(expr.expr2, mv);
                        mv.visitInsn(Opcodes.IADD);
                    }
                    case "-" -> {
                        genExpr(expr.expr1, mv);
                        genExpr(expr.expr2, mv);
                        mv.visitInsn(Opcodes.ISUB);
                    }
                    case "*" -> {
                        genExpr(expr.expr1, mv);
                        genExpr(expr.expr2, mv);
                        mv.visitInsn(Opcodes.IMUL);
                    }
                    case "/" -> {
                        genExpr(expr.expr1, mv);
                        genExpr(expr.expr2, mv);
                        mv.visitInsn(Opcodes.IDIV);
                    }
                }
                break;
            case "boolean":
                switch (expr.eval) {
                    case "and","&&" -> {
                        genExpr(expr.expr1, mv);
                        genExpr(expr.expr2, mv);
                        mv.visitInsn(Opcodes.IAND);
                    }
                    case "or","||" -> {
                        genExpr(expr.expr1, mv);
                        genExpr(expr.expr2, mv);
                        mv.visitInsn(Opcodes.IOR);
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

    private static void genUnaryExpr(UnaryExpr expr, MethodVisitor mv){
        switch (expr.eval){
            case "-":
                genExpr(expr.expr, mv);
                mv.visitInsn(Opcodes.INEG);
                break;
            case "not","!":
                Label retzero = new Label();
                Label end = new Label();

                genExpr(expr.expr, mv);

                mv.visitJumpInsn(Opcodes.IFNE, retzero);
                mv.visitInsn(Opcodes.ICONST_1);
                mv.visitJumpInsn(Opcodes.GOTO, end);

                mv.visitLabel(retzero);
                mv.visitInsn(Opcodes.ICONST_0);

                mv.visitLabel(end);
                break;
        }
    }


    private static void genLocalOrFieldVarExpr(LocalOrFieldVarExpr var, MethodVisitor mv) {
        String type = "asdf"; //TODO: get type from expression

        //TODO:
        // look for variable names in parameters, locals and fields
        // a name cannot occur both in locals and parameters!
        // this means, that the method at hand has to know about the fields of the class, the method parameters and the local variables


    }


}
