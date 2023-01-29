package syntaxtree.expressions;

public final class BinaryExpr extends Expression {

    public final Expression expr1;
    public final Expression expr2;
    public final String eval;

    public BinaryExpr (Expression expr1, Expression expr2, String eval) {
        this.expr1 = expr1;
        this.expr2 = expr2;
        this.eval = eval;
    }

    @Override
    public String toString() {
        return "(" + eval + super.toString() + expr1 + " " + expr2 + ")";
    }
}
