package syntaxtree.expressions;

public final class JNullExpr extends Expression {
    public JNullExpr(){  }

    @Override
    public String toString() {
        return "(" + this.type + ")";
    }
}
