package syntaxtree;

public final class ReturnStmt extends  Statement {

    final Expression rExpr;

    public  ReturnStmt(Expression expr) {
        this.rExpr = expr;
    }

}
