package syntaxtree.statementexpressions;

import syntaxtree.expressions.Expression;

import java.util.Vector;

public final class MethodCallStmtExpr extends StatementExpression {

    public Expression obj;
    public final String meth;
    public final Vector<Expression> methParams;

    public MethodCallStmtExpr (Expression obj, String meth, Vector<Expression> methParams) {
        this.obj = obj;
        this.meth = meth;
        this.methParams = methParams;
    }

    @Override
    public String toString() {
        String result = "(MethodCall" + super.toString() + obj + " " + meth + " [";
        if (methParams != null) {
            for (Expression e : methParams) {
                result += e + " ";
            }
        }
        result = result.substring(0, result.length() - 1) + "])";
        return result;
    }
}
