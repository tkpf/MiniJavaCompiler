package syntaxtree.statementexpressions;

import syntaxtree.expressions.Expression;
import syntaxtree.Type;

import java.util.Vector;

public final class NewStmtExpr extends StatementExpression {

    public final String name;
    public final Vector<Expression> initParams;

    public NewStmtExpr (Type type, Vector<Expression> initParams) {
        // TODO: refactor
        this.name = type.name;
        this.initParams = initParams;
    }

    @Override
    public String toString() {
        String result = "(New" + super.toString() + name + " [";
        if (initParams != null) {
            for (Expression e : initParams) {
                result += e + " ";
            }
        }
        result += "])";
        return result;
    }
}
