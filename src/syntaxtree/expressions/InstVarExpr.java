package syntaxtree.expressions;

public final class InstVarExpr extends Expression {

    public final Expression inst;
    public final String name;

    public InstVarExpr (Expression inst, String name) {
        this.inst = inst;
        this.name = name;
    }

    @Override
    public String toString() {
        return "(InstVar " + inst + " " + name + ")";
    }
}
