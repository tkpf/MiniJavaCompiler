package parser.adapter;

import syntaxtree.expressions.Expression;
import syntaxtree.expressions.InstVarExpr;
import syntaxtree.expressions.LocalOrFieldVarExpr;

public class InstVarExpressionAdapter {
    public static Expression adapt (Expression varExpr, String varName) {
        return new InstVarExpr(varExpr, varName);
    }
}
