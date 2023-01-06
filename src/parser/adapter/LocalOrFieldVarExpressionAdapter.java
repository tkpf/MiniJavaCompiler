package parser.adapter;

import parser.production.JavaMiniParser;
import syntaxtree.expressions.Expression;
import syntaxtree.expressions.LocalOrFieldVarExpr;

public class LocalOrFieldVarExpressionAdapter {
    public static Expression adapt (JavaMiniParser.PrimaryContext ctx) {
        return new LocalOrFieldVarExpr(ctx.Identifier().getText());
    }
}
