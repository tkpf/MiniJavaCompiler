package syntaxtree.expressions;

public final class CharExpr extends Expression {
    final private char c;

    public CharExpr(char c) { this.c = c; }

    @Override
    public String toString() {
        return "(" + this.type + " " + this.c + ")";
    }
}
