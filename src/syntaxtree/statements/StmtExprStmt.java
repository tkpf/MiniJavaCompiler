package syntaxtree.statements;

import syntaxtree.statementexpressions.StatementExpression;

public final class StmtExprStmt extends Statement {

    public final StatementExpression stmtExpr;

    public  StmtExprStmt (StatementExpression stmtExpr) {
        this.stmtExpr = stmtExpr;
    }

}
