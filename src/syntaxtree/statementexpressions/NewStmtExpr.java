package syntaxtree.statementexpressions;

import syntaxtree.expressions.Expression;
import syntaxtree.expressions.Type;

import java.util.Vector;

public final class NewStmtExpr extends StatementExpression {

    private final Type type;
    private final Vector<Expression> initParams;

    public NewStmtExpr (Type type, Vector<Expression> initParams) {
        this.type = type;
        this.initParams = initParams;
    }


}
