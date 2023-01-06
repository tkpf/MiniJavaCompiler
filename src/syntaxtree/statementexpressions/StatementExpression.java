package syntaxtree.statementexpressions;

import syntaxtree.statementexpressions.AssignStmtExpr;
import syntaxtree.statementexpressions.MethodCallStmtExpr;
import syntaxtree.statementexpressions.NewStmtExpr;

public abstract sealed class StatementExpression permits AssignStmtExpr, NewStmtExpr, MethodCallStmtExpr {
}
