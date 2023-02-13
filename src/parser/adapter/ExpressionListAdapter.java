package parser.adapter;

import parser.exceptions.EscapeHatchException;
import parser.production.JavaMiniParser;
import syntaxtree.expressions.Expression;

import java.util.List;
import java.util.Vector;

public class ExpressionListAdapter {
    public static Vector<Expression> adapt (JavaMiniParser.ExpressionListContext ctx) throws EscapeHatchException {
        Vector<Expression> exprList = new Vector<>();

        // check if expression list is not empty
        if (ctx != null) {
            List<JavaMiniParser.ExpressionContext> exprCtxList = ctx.expression();
            for (JavaMiniParser.ExpressionContext exprCtx : exprCtxList) {
                exprList.add(ExpressionAdapter.adapt(exprCtx));
            }
        }

        return exprList;
    }
}
