package syntaxtree.expressions;

public final class FieldVar extends Expression{
    public final String name;

    public FieldVar (String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "(Field " + name + ")";
    }
}
