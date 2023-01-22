package syntaxtree.statementexpressions;

import syntaxtree.expressions.Expression;

import java.util.Vector;

public final class MethodCallStmtExpr extends StatementExpression {

    public final Expression obj;
    public final String meth;
    public final Vector<Expression> methParams; //todo datatype right?

    public MethodCallStmtExpr (Expression obj, String meth, Vector<Expression> methParams) {
        this.obj = obj;
        this.meth = meth;
        this.methParams = methParams;
    }

    @Override
    public String toString() {
        return "(MethodCall " + this.meth + " " + this.methParams.toString() + ")";
    }
}
