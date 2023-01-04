package syntaxtree;

public final class ThisExpr extends Expression {

    private final Class thisClass;

    public ThisExpr(Class thisClass) {
        this.thisClass = thisClass;
    }

}
