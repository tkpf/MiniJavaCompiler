package parser.adapter;

import parser.production.JavaMiniParser;
import syntaxtree.Field;
import syntaxtree.Method;
import syntaxtree.expressions.Type;

public class FieldAdapter {

    public static Field adapt(JavaMiniParser.FieldDeclarationContext ctx) {

        // Todo try catch
        final String name = ctx.variableDeclarator().variableDeclaratorId().getText();
        final Type type = TypeAdapter.adapt(ctx.type());

        return new Field(name, type);
    }
}