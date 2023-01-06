package syntaxtree.expressions;

public final class InstVarExpr extends Expression {

    private final Expression inst; // TODO should I do casts? e.g. to LocalOrFieldVar
    private final String name;

    public InstVarExpr (Expression inst, String name) {
        this.inst = inst;
        this.name = name;
    }

}
