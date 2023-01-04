package syntaxtree;

import java.util.Vector;

public final class MethodCallStmtExpr extends StatementExpression {

    private final Expression obj;
    private final String meth;
    private final Vector<Expression> methParams; //todo datatype right?

    public MethodCallStmtExpr (Expression obj, String meth, Vector<Expression> methParams) {
        this.obj = obj;
        this.meth = meth;
        this.methParams = methParams;
    }


}
