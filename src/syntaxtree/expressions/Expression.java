package syntaxtree.expressions;

import syntaxtree.Type;

public abstract sealed class Expression
        permits StringExpr, BinaryExpr, BoolExpr, CharExpr, InstVarExpr, IntegerExpr, JNullExpr, LocalOrFieldVarExpr, StmtExprExpr, SuperExpr, ThisExpr, UnaryExpr, LocalVar, FieldVar {

    public Type type;

    public void codeGen() {
        //todo implement codeGen
    }

}
