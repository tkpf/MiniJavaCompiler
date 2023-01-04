package syntaxtree;

public final class SuperExpr extends Expression {

    private final Class superClass;

    public SuperExpr (Class superClass) {
        this.superClass = superClass;
    }

}
