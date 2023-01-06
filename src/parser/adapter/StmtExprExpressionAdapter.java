package parser.adapter;

import syntaxtree.expressions.StmtExprExpr;
import syntaxtree.statementexpressions.StatementExpression;

public class StmtExprExpressionAdapter {
    public static StmtExprExpr adapt (StatementExpression stmtExpr) {
        return new StmtExprExpr(stmtExpr);
    }
}
