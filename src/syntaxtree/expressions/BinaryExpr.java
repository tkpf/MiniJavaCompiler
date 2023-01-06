package syntaxtree.expressions;

public final class BinaryExpr extends Expression {

    private final Expression expr1;
    private final Expression expr2;
    private final String eval;

    public BinaryExpr (Expression expr1, Expression expr2, String eval) {
        this.expr1 = expr1;
        this.expr2 = expr2;
        this.eval = eval;
    }

}
