package syntaxtree.expressions;

import syntaxtree.Type;

public abstract sealed class Expression
        permits StringExpr, BinaryExpr, BoolExpr, CharExpr, InstVarExpr, IntegerExpr, JNullExpr, LocalOrFieldVarExpr, StmtExprExpr, ThisExpr, UnaryExpr {

    public Type type;


    @Override
    public String toString() {
        if (type != null) {
            return ":" + type + " ";
        } else {
            return ": ";
        }
    }
}
