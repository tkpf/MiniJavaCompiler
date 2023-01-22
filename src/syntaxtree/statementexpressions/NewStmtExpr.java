package syntaxtree.statementexpressions;

import syntaxtree.expressions.Expression;
import syntaxtree.Type;

import java.util.Vector;

public final class NewStmtExpr extends StatementExpression {

    public final Type type;
    public final Vector<Expression> initParams;

    public NewStmtExpr (Type type, Vector<Expression> initParams) {
        this.type = type;
        this.initParams = initParams;
    }


}
