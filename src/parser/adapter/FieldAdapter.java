package parser.adapter;

import parser.production.JavaMiniParser;
import syntaxtree.Field;
import syntaxtree.Type;
import syntaxtree.expressions.FieldVar;
import syntaxtree.expressions.StmtExprExpr;
import syntaxtree.statementexpressions.AssignStmtExpr;
import syntaxtree.statementexpressions.NewStmtExpr;
import syntaxtree.statements.BlockStmt;
import syntaxtree.statements.Statement;
import syntaxtree.statements.StmtExprStmt;
import syntaxtree.statements.VarDeclStmt;

import javax.swing.plaf.nimbus.State;
import java.util.Arrays;
import java.util.Vector;

public class FieldAdapter {

    public static Statement adapt(JavaMiniParser.FieldDeclarationContext ctx, boolean directInit) {

        // Todo try catch


        final String name = ctx.variableDeclarator().variableDeclaratorId().getText();
        final Type type = TypeAdapter.adapt(ctx.type());
        final VarDeclStmt declStmt = new VarDeclStmt(name, type);

        // differentiate in between direct Initialization and only declaration
        if (!directInit) {
            return declStmt;
        }
        else {
            AssignStmtExpr initAssignStmtExpr = new AssignStmtExpr(
                    new FieldVar(name),
                    ExpressionAdapter.adapt(ctx.variableDeclarator().directInitialization().expression())
                    );
            Statement[] tempArray = new Statement[] {
                    declStmt,
                    new StmtExprStmt(initAssignStmtExpr)
            };
            return new BlockStmt(new Vector<>(Arrays.asList(tempArray)));

        }
    }
}
