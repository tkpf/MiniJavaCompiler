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
    public static void genExpr(Expression exp, Method m) {
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
                if (e.b) {
                    m.visitor.visitInsn(Opcodes.ICONST_1);
                } else {
                    m.visitor.visitInsn(Opcodes.ICONST_0);
                }
                break;
            case StringExpr e:
                m.visitor.visitLdcInsn(e.s);
                break;
            case JNullExpr e:
                m.visitor.visitInsn(Opcodes.ACONST_NULL);
                break;
            case LocalOrFieldVarExpr e:
                switch (e.context) {
                    case local -> genLocalVar(e, m);
                    case field -> genFieldVar(e, m);
                    case unknown -> throw new IllegalStateException("Variable unknown!");
                }
                break;
            case InstVarExpr e:
                genInstVar(e, m);
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
                m.visitor.visitLdcInsn(Object.class);
                break;
            case StmtExprExpr e:
                genStmtExpr(e.stmtExprExpr, m);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + exp);
        }
    }

    private static void genBinaryExpr(BinaryExpr expr, Method m) {
        switch (expr.type.name) {
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
                    case "<" -> {
                        genExpr(expr.expr1, m);
                        genExpr(expr.expr2, m);

                        Label retfalse = new Label();
                        Label end = new Label();

                        m.visitor.visitJumpInsn(Opcodes.IF_ICMPGE, retfalse);
                        m.visitor.visitInsn(Opcodes.ICONST_1);
                        m.visitor.visitJumpInsn(Opcodes.GOTO, end);

                        m.visitor.visitLabel(retfalse);
                        m.visitor.visitInsn(Opcodes.ICONST_0);

                        m.visitor.visitLabel(end);
                    }
                    case "==" -> {
                        genExpr(expr.expr1, m);
                        genExpr(expr.expr2, m);

                        Label retfalse = new Label();
                        Label end = new Label();

                        m.visitor.visitJumpInsn(Opcodes.IF_ICMPNE, retfalse);
                        m.visitor.visitInsn(Opcodes.ICONST_1);
                        m.visitor.visitJumpInsn(Opcodes.GOTO, end);

                        m.visitor.visitLabel(retfalse);
                        m.visitor.visitInsn(Opcodes.ICONST_0);

                        m.visitor.visitLabel(end);
                    }
                }
                break;
            case "boolean":
                switch (expr.eval) {
                    case "and", "&&" -> {
                        genExpr(expr.expr1, m);
                        genExpr(expr.expr2, m);
                        m.visitor.visitInsn(Opcodes.IAND);
                    }
                    case "or", "||" -> {
                        genExpr(expr.expr1, m);
                        genExpr(expr.expr2, m);
                        m.visitor.visitInsn(Opcodes.IOR);
                    }
                }
                break;
            case "String":
                // TODO
                switch (expr.eval) {
                    case "+":
                        genExpr(expr.expr1, m);
                        genExpr(expr.expr2, m);
                        m.visitor.visitMethodInsn(
                                Opcodes.INVOKEVIRTUAL,
                                "java/lang/String",
                                "concat",
                                "(Ljava/lang/String;)Ljava/lang/String",
                                false);
                        break;
                }
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + expr.type.name);
        }
    }

    private static void genUnaryExpr(UnaryExpr expr, Method m) {
        switch (expr.eval) {
            case "-":
                genExpr(expr.expr, m);
                m.visitor.visitInsn(Opcodes.INEG);
                break;
            case "not", "!":
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


    private static void genLocalVar(LocalOrFieldVarExpr v, Method m) {
        String type = v.type.name;
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

    private static void genFieldVar(LocalOrFieldVarExpr f, Method m) {
        String type = f.type.name;

        m.visitor.visitFieldInsn(Opcodes.GETFIELD, f.type.name, f.name, fieldDescriptor(f.type.name));
    }

    private static void genInstVar(InstVarExpr var, Method m) {
        genExpr(var.inst, m);
        m.visitor.visitFieldInsn(Opcodes.GETFIELD, var.inst.type.name, var.name, fieldDescriptor(var.type.name));
    }

}
