package syntaxtree.statements;

import syntaxtree.expressions.Expression;

public final class ReturnStmt extends Statement {

    public final Expression rExpr;

    public  ReturnStmt(Expression expr) {
        this.rExpr = expr;
    }

    @Override
    public String toString() {
        return "(Return " + rExpr + ")";
    }
}
