package parser.adapter;

import parser.exceptions.EscapeHatchException;
import parser.production.JavaMiniParser;
import syntaxtree.Type;
import syntaxtree.Field;
import syntaxtree.expressions.LocalOrFieldVarExpr;
import syntaxtree.statementexpressions.AssignStmtExpr;
public class FieldAdapter {

    public static Field adapt(JavaMiniParser.FieldDeclarationContext ctx, boolean directInit) throws EscapeHatchException {

        final String name = ctx.variableDeclarator().variableDeclaratorId().getText();
        final Type type = TypeAdapter.adapt(ctx.type());
        final Field field = new Field(name, type);

        // check if directInit takes place, if so fill assignment field
        if (directInit) {
            field.assignment = new AssignStmtExpr(
                    new LocalOrFieldVarExpr(name),
                    ExpressionAdapter.adapt(ctx.variableDeclarator().directInitialization().expression())
            );

        }
        return field;
    }
}
