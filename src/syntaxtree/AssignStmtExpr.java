package syntaxtree;

public final class AssignStmtExpr extends StatementExpression{

    private final Expression as2Expr;
    private final Expression asFromExpr;

    public AssignStmtExpr (Expression as2Expr, Expression asFromExpr) {
        this.as2Expr = as2Expr;
        this.asFromExpr = asFromExpr;
    }

}
