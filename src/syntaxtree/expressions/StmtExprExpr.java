package syntaxtree.expressions;

import syntaxtree.statementexpressions.StatementExpression;

public final class StmtExprExpr extends Expression {

    public final StatementExpression stmtExprExpr;

    public StmtExprExpr (StatementExpression stmtExprExpr) {
        this.stmtExprExpr = stmtExprExpr;
    }


}
