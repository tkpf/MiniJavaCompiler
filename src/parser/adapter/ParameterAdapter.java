package parser.adapter;

import parser.production.JavaMiniParser;
import syntaxtree.Parameter;
import syntaxtree.expressions.Type;

public class ParameterAdapter {
    public static Parameter adapt (JavaMiniParser.FormalParameterContext ctx) {
        final String name = ctx.variableDeclaratorId().getText();
        final Type type = TypeAdapter.adapt(ctx.type());

        return new Parameter(name, type);
    }
}
