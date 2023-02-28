package syntaxtree.expressions;

public final class CharExpr extends Expression {
    final public char c;

    public CharExpr(char c) { this.c = c; }

    @Override
    public String toString() {
        return "(char " + this.c + ")";
    }
}
