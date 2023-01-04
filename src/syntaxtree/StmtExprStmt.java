package syntaxtree;

public final class StmtExprStmt extends Statement {

    private final StatementExpression stmtExpr;

    public  StmtExprStmt (StatementExpression stmtExpr) {
        this.stmtExpr = stmtExpr;
    }

}
