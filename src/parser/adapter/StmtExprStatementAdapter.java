package parser.adapter;

import syntaxtree.statementexpressions.StatementExpression;
import syntaxtree.statements.StmtExprStmt;

public class StmtExprStatementAdapter {
    public static StmtExprStmt adapt(StatementExpression stmtExpr) {
        return new StmtExprStmt(stmtExpr);
    }
}
