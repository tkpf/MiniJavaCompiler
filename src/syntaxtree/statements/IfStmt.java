package syntaxtree.statements;

import syntaxtree.expressions.Expression;

public final class IfStmt extends Statement {

    //todo is boolean datatype right or shold i implement boolExpr?
    public final Expression boolExpr;
    public final BlockStmt ifBlck;
    public final BlockStmt elseBlck;

    public IfStmt(Expression boolExpr, BlockStmt ifBlck, BlockStmt elseBlck) {
        this.boolExpr = boolExpr;
        this.ifBlck = ifBlck;
        this.elseBlck = elseBlck;
    }

    public IfStmt(Expression boolExpr, BlockStmt ifBlck) {
        this.boolExpr = boolExpr;
        this.ifBlck = ifBlck;
        this.elseBlck = null;
    }

}
