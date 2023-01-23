package syntaxtree.expressions;

import syntaxtree.Class;

public final class ThisExpr extends Expression {

    public ThisExpr() {}

    @Override
    public String toString() {
        return "(This)";
    }
}
