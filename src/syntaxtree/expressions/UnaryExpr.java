package syntaxtree.expressions;

public final class UnaryExpr extends Expression {

    public final Expression expr;
    public final String eval;

    public UnaryExpr (Expression expr, String eval) {
        this.expr = expr;
        this.eval = eval;
    }



}
