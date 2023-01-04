package syntaxtree;

public final class UnaryExpr extends Expression {

    private final Expression expr;
    private final String eval;

    public UnaryExpr (Expression expr, String eval) {
        this.expr = expr;
        this.eval = eval;
    }



}
