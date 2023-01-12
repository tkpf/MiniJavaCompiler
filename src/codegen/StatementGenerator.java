package codegen;

import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import syntaxtree.expressions.Expression;
import syntaxtree.statements.*;

import static codegen.ExpressionGenerator.*;

public class StatementGenerator {
    public static void genStmt(Statement stmt, MethodVisitor mv)
    {
        switch (stmt) {
            case null:
                mv.visitInsn(Opcodes.NOP);
                break;
            case BlockStmt s:
                s.stmtBlck.forEach(b -> genStmt(b, mv));
                break;
            case ReturnStmt s:
                genReturnStmt(s.rExpr, mv);
                break;
            case LocalVarDeclStmt s:
                //TODO
                break;
            case IfStmt s:
                genIfStmt(s, mv);
                break;
            case WhileStmt s:
                genWhileStmt(s, mv);
                break;
            case StmtExprStmt s:
                //TODO
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + stmt);
        }

    }
    public static void genReturnStmt(Expression rexpr, MethodVisitor mv)
    {
        String type = "int"; //TODO: get type from rexpr
        switch (type) {
            case "int", "char", "boolean" -> {
                genExpr(rexpr, mv);
                mv.visitInsn(Opcodes.IRETURN);
            }
            case "String", "null" -> {
                genExpr(rexpr, mv);
                mv.visitInsn(Opcodes.ARETURN);
            }
        }
    }

    private static void genIfStmt(IfStmt stmt, MethodVisitor mv){
        Label elseBranch = new Label();
        Label end = new Label();

        genExpr(stmt.boolExpr, mv);
        mv.visitJumpInsn(Opcodes.IFEQ, elseBranch);
        genStmt(stmt.ifBlck, mv);
        mv.visitJumpInsn(Opcodes.GOTO, end);

        mv.visitLabel(elseBranch);
        genStmt(stmt.elseBlck, mv);

        mv.visitLabel(end);
    }

    private static void genWhileStmt(WhileStmt stmt, MethodVisitor mv){
        Label loop = new Label();
        Label end = new Label();

        mv.visitLabel(loop);
        genExpr(stmt.boolExpr, mv);
        mv.visitJumpInsn(Opcodes.IFEQ, end);

        genStmt(stmt.blck, mv);
        mv.visitJumpInsn(Opcodes.GOTO, loop);

        mv.visitLabel(end);
    }
}
