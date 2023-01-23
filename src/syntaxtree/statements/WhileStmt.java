package syntaxtree.statements;

import syntaxtree.expressions.Expression;

public final class WhileStmt extends Statement {

    public final Expression boolExpr;
    public final BlockStmt blck;

    public WhileStmt(Expression boolExpr, BlockStmt blck) {
        this.boolExpr = boolExpr;
        this.blck = blck;
    }

    @Override
    public String toString() {
        return "(While " + boolExpr + " " + blck + ")";
    }
}
