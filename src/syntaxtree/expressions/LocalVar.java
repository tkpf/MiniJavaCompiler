package syntaxtree.expressions;

public final class LocalVar extends Expression {
    public final String name;

    public LocalVar (String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "(Local " + name + ")";
    }
}
