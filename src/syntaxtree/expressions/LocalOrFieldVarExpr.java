package syntaxtree.expressions;

public final class LocalOrFieldVarExpr extends Expression {

    public final String name;

    public LocalOrFieldVarExpr (String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "(LoFVar " + name + ")";
    }
}
