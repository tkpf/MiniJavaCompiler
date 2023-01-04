package syntaxtree;

public final class WhileStmt extends Statement {

    private final Expression boolExpr;
    private final BlockStmt blck;

    public WhileStmt(Expression boolExpr, BlockStmt blck) {
        this.boolExpr = boolExpr;
        this.blck = blck;
    }



}
