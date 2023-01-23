package syntaxtree.statementexpressions;

import syntaxtree.AST;
import syntaxtree.Type;

public abstract sealed class StatementExpression extends AST permits AssignStmtExpr, NewStmtExpr, MethodCallStmtExpr {

    public Type type;

    @Override
    public String toString() { return "{" + type + "}"; }
}
