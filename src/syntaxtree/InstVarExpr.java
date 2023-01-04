package syntaxtree;

public final class InstVarExpr extends Expression {

    private final LocalOrFieldVarExpr inst;
    private final String name;

    public InstVarExpr (LocalOrFieldVarExpr inst, String name) {
        this.inst = inst;
        this.name = name;
    }

}
