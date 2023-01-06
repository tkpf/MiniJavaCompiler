package parser.adapter;

import parser.production.JavaMiniParser;
import syntaxtree.expressions.Expression;
import syntaxtree.expressions.StmtExprExpr;
import syntaxtree.statementexpressions.AssignStmtExpr;
import syntaxtree.statementexpressions.NewStmtExpr;
import syntaxtree.statementexpressions.StatementExpression;

import java.util.List;
import java.util.Vector;

public class ExpressionAdapter {

    static Expression adapt(JavaMiniParser.ExpressionContext ctx) {
        if (ctx.primary() != null) {
            return PrimaryExpressionAdapter.adapt(ctx.primary());
        }
        else if (ctx.binaryLiterals() != null) {
            //Binary Expression
            return BinaryExpressionAdapter.adapt(
                    ExpressionAdapter.adapt(ctx.expression(0)),
                    ExpressionAdapter.adapt(ctx.expression(1)),
                    ctx.binaryLiterals().start.getText());
        }
        else if (ctx.unaryLiterals() != null) {
            //Unary Expression
            return UnaryExpressionAdapter.adapt(
                    ExpressionAdapter.adapt(ctx.expression(0)),
                    ctx.unaryLiterals().start.getText());
        }
        else if (ctx.InstLiteral() != null) {
            //InstVar
            return InstVarExpressionAdapter.adapt(
                    ExpressionAdapter.adapt(
                            ctx.expression(0)),
                    ctx.Identifier().getText());
        }
        else {
            StatementExpression stmtExpr = StatementExpressionAdapter.adapt(ctx);
            return new StmtExprExpr(stmtExpr);
        } // StatementExpression

    }
}
