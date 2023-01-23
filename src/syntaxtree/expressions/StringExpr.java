package syntaxtree.expressions;

public final class StringExpr extends Expression {
    public final String s;

    public StringExpr(String s) { this.s = s; }

    @Override
    public String toString() {
        return "(String " + this.s + ")";
    }
}
