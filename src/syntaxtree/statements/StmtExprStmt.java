package syntaxtree.statements;

import syntaxtree.statementexpressions.StatementExpression;

public final class StmtExprStmt extends Statement {

    private final StatementExpression stmtExpr;

    public  StmtExprStmt (StatementExpression stmtExpr) {
        this.stmtExpr = stmtExpr;
    }

}
