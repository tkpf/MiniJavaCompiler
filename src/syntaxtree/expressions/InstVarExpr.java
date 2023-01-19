package syntaxtree.expressions;

public final class InstVarExpr extends Expression {

    public final Expression inst; // TODO should I do casts? e.g. to LocalOrFieldVar
    public final String name;

    public InstVarExpr (Expression inst, String name) {
        this.inst = inst;
        this.name = name;
    }

}
