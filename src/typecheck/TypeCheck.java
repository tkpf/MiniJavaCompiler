package typecheck;

import syntaxtree.Program;
import syntaxtree.expressions.*;
import syntaxtree.statements.*;
import syntaxtree.statementexpressions.*;

public class TypeCheck {

    public static void type(Program prog) {
        ;
    }

    public void typeExpression(Expression exp) {
        switch (exp) {
            case (BoolExpr e)  -> exp.type = new Type("bool");
            case (CharExpr e)    -> exp.type = new Type("char");
            case (IntegerExpr e) -> exp.type = new Type("int");
            case (JNullExpr e)   -> exp.type = new Type("null");
            case (StringExpr e)  -> exp.type = new Type("String");

            case BinaryExpr binaryExpr -> {
            }
            case InstVarExpr instVarExpr -> {
            }
            case LocalOrFieldVarExpr localOrFieldVarExpr -> {
            }
            case StmtExprExpr stmtExprExpr -> {
            }
            case SuperExpr superExpr -> {
            }
            case ThisExpr thisExpr -> {
            }
            case UnaryExpr unaryExpr -> {
            }
            case LocalVar localVar -> {
            }
            case FieldVar fieldVar -> {
            }
        }
    }

    public void typeStatement(Statement stmt) {
        switch (stmt) {

            case BlockStmt blockStmt -> {
            }
            case ReturnStmt returnStmt -> {
            }
            case IfStmt ifStmt -> {
            }
            case WhileStmt whileStmt -> {
            }
            case LocalVarDeclStmt localVarDeclStmt -> {
            }
            case StmtExprStmt stmtExprStmt -> {
            }
        }
    }
    public void typeStatementExpression(StatementExpression stmtExp) {
        switch (stmtExp) {

            case AssignStmtExpr assignStmtExpr -> {
            }
            case NewStmtExpr newStmtExpr -> {
            }
            case MethodCallStmtExpr methodCallStmtExpr -> {
            }
        }
    }
}
