package syntaxtree.expressions;

import syntaxtree.Class;

public final class SuperExpr extends Expression {

    public SuperExpr () {}

    @Override
    public String toString() {
        return "(Super)";
    }
}
