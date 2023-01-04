package syntaxtree;

public abstract sealed class StatementExpression permits AssignStmtExpr, NewStmtExpr, MethodCallStmtExpr {
}
