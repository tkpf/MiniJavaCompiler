package codegen;

import org.objectweb.asm.Label;
import org.objectweb.asm.Opcodes;
import syntaxtree.Method;
import syntaxtree.Type;
import syntaxtree.expressions.Expression;
import syntaxtree.expressions.JNullExpr;
import syntaxtree.statements.*;
import static codegen.StatementExpressionGenerator.genStmtExpr;
import static codegen.ExpressionGenerator.*;

public class StatementGenerator {
    public static void genStmt(Statement stmt, Method m)
    {
        switch (stmt) {
            case null -> m.visitor.visitInsn(Opcodes.NOP);
            case BlockStmt s -> {
                s.stmtBlck.forEach(b -> genStmt(b, m)); // todo: delete local variables after block is closed

                // adding 'return;' at the end of void-blocks in case they are not explicit in the code (since java allows to omit them)
                if (s.stmtBlck.isEmpty() ||
                        (s.type.name == "void" && s.stmtBlck.lastElement().getClass() != ReturnStmt.class))
                {
                    Expression emptyVoidRexpr = new JNullExpr(); //TODO: the JNUll is just a dummy that shouldn't be read
                    emptyVoidRexpr.type = new Type("void");
                    genReturnStmt(emptyVoidRexpr, m);
                }
            }
            case ReturnStmt s -> genReturnStmt(s.rExpr, m);
            case VarDeclStmt s -> m.localVariableIndexes.put(s.name, m.localVariableIndexes.size() + 1);
            case IfStmt s -> genIfStmt(s, m);
            case WhileStmt s -> genWhileStmt(s, m);
            case StmtExprStmt s -> genStmtExpr(s.stmtExpr, m);
            default -> throw new IllegalStateException("Unexpected value: " + stmt);
        }

    }
    public static void genReturnStmt(Expression rexpr, Method m)
    {
        String type = rexpr.type.name;
        switch (type) {
            case "int", "char", "boolean" -> {
                genExpr(rexpr, m);
                m.visitor.visitInsn(Opcodes.IRETURN);
            }
            case "String", "null" -> {
                genExpr(rexpr, m);
                m.visitor.visitInsn(Opcodes.ARETURN);
            }
            case "void" -> {
                m.visitor.visitInsn(Opcodes.RETURN);
            }
        }
    }

    private static void genIfStmt(IfStmt stmt, Method m){
        Label elseBranch = new Label();
        Label end = new Label();

        genExpr(stmt.boolExpr, m);
        m.visitor.visitJumpInsn(Opcodes.IFEQ, elseBranch);
        genStmt(stmt.ifBlck, m);
        m.visitor.visitJumpInsn(Opcodes.GOTO, end);

        m.visitor.visitLabel(elseBranch);
        genStmt(stmt.elseBlck, m);

        m.visitor.visitLabel(end);
    }

    private static void genWhileStmt(WhileStmt stmt, Method m){
        Label loop = new Label();
        Label end = new Label();

        m.visitor.visitLabel(loop);
        genExpr(stmt.boolExpr, m);
        m.visitor.visitJumpInsn(Opcodes.IFEQ, end);

        genStmt(stmt.blck, m);
        m.visitor.visitJumpInsn(Opcodes.GOTO, loop);

        m.visitor.visitLabel(end);
    }

}
