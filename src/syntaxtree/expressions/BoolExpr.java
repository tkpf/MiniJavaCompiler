package syntaxtree.expressions;

public final class BoolExpr extends Expression {
    final public boolean b;

    public BoolExpr(boolean b) { this.b = b; }

    @Override
    public String toString() {
        return "(boolean " + this.b + ")";
    }
}
