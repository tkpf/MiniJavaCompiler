package syntaxtree.statementexpressions;

import syntaxtree.Type;

public abstract sealed class StatementExpression permits AssignStmtExpr, NewStmtExpr, MethodCallStmtExpr {

    public Type type;

    @Override
    public String toString() {
        if (type != null) {
            return ": " + type;
        } else {
            return ": ";
        }
    }
}
