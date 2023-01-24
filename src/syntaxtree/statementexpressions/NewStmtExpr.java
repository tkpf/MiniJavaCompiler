package syntaxtree.statementexpressions;

import syntaxtree.expressions.Expression;
import syntaxtree.Type;

import java.util.Vector;

public final class NewStmtExpr extends StatementExpression {

    public final Vector<Expression> initParams;

    public NewStmtExpr (Type type, Vector<Expression> initParams) {
        this.type = type;
        this.initParams = initParams;
    }

    @Override
    public String toString() {
        String result = "(New " + type + " [";
        for (Expression e : initParams) {
            result += e + " ";
        }
        result += "])";
        return result;
    }
}
