package syntaxtree.expressions;

public final class IntegerExpr extends Expression {
    public final int i;

    public IntegerExpr(int i) { this.i = i; }

    @Override
    public String toString() {
        return "(" + this.type + " " + this.i + ")";
    }
}
