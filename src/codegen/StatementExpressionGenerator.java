package codegen;

import syntaxtree.Method;
import syntaxtree.statementexpressions.*;



public class StatementExpressionGenerator {
    public static void genStmtExpr(StatementExpression stx, Method m) {
        switch (stx){
            case AssignStmtExpr s:
                genAssign(s, m);
                break;
            case MethodCallStmtExpr s:
                break;
            case NewStmtExpr s:
                break;
            case StatementExpression s:
                break;
        }
    }

    public static void genAssign(AssignStmtExpr s, Method m){

    }
}
