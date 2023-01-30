package syntaxtree.statementexpressions;

import syntaxtree.expressions.Expression;

public final class AssignStmtExpr extends StatementExpression {

    public final Expression as2Expr;
    public final Expression asFromExpr;

    public AssignStmtExpr (Expression as2Expr, Expression asFromExpr) {
        this.as2Expr = as2Expr;
        this.asFromExpr = asFromExpr;
    }

    @Override
    public String toString() {
        return "(Assign" + super.toString() + as2Expr + " " + asFromExpr + ")";
    }
}
