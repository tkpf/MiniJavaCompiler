package parser.adapter;

import parser.production.JavaMiniParser;
import syntaxtree.expressions.Expression;

import java.util.List;
import java.util.Vector;

public class ExpressionListAdapter {
    public static Vector<Expression> adapt (JavaMiniParser.ExpressionListContext ctx) {
        if (ctx == null) {
            //return empty vector
            return new Vector<Expression>();
        }
        Vector<Expression> exprList = new Vector<>();
        List<JavaMiniParser.ExpressionContext> exprCtxList = ctx.expression();
        for (JavaMiniParser.ExpressionContext exprCtx : exprCtxList) {
            exprList.add(ExpressionAdapter.adapt(exprCtx));
        }
        return exprList;
    }
}
