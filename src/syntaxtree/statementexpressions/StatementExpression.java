package syntaxtree.statementexpressions;

import syntaxtree.expressions.Type;
import syntaxtree.statementexpressions.AssignStmtExpr;
import syntaxtree.statementexpressions.MethodCallStmtExpr;
import syntaxtree.statementexpressions.NewStmtExpr;

public abstract sealed class StatementExpression permits AssignStmtExpr, NewStmtExpr, MethodCallStmtExpr {
    public Type type;
}
