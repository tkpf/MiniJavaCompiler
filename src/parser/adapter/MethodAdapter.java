package parser.adapter;

import parser.production.JavaMiniParser;
import syntaxtree.BlockStmt;
import syntaxtree.Method;
import syntaxtree.Parameter;

import java.util.Vector;

public class MethodAdapter {

    public static Method adapt(JavaMiniParser.MethodDeclarationContext ctx) {

        //TODO try catch
        final String name = ctx.Identifier().getText();
        final String rtype;
        final Vector<Parameter> params = new Vector<>();
        final BlockStmt body;

        // load rtype
        if (ctx.type()!= null) {
            rtype = ctx.type().getText();
        }
        else {
            rtype = "void";
        }

        // load params
        if (ctx.formalParameters().formalParameterDecls() != null) {
            for (JavaMiniParser.FormalParameterContext parCtx: ctx.formalParameters().formalParameterDecls().formalParameter()) {
                params.add(ParameterAdapter.adapt(parCtx));
            }
        }
        else params = null; // TODO case no given params

        // load body
        if (ctx.methodDeclarationRest().methodBody() != null) {
            body = BlockStmtAdapter.adapt(ctx.methodDeclarationRest().methodBody().block());
        }

        return new Method(name, rtype, params, body);
    }
}
