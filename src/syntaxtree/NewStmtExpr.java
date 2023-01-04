package syntaxtree;

import java.util.Vector;

public final class NewStmtExpr extends StatementExpression {

    private final TypeExpr type;
    private final Vector<Expression> initParams;

    public NewStmtExpr (TypeExpr type, Vector<Expression> initParams) {
        this.type = type;
        this.initParams = null; // todo implement initParams; must we change type class?
    }

}
