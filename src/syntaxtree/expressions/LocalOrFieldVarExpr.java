package syntaxtree.expressions;

public final class LocalOrFieldVarExpr extends Expression {

    private final String name;

    public LocalOrFieldVarExpr (String name) {
        this.name = name;
    }


}