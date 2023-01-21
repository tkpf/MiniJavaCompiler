package syntaxtree.expressions;

public abstract sealed class Expression permits StringExpr, BinaryExpr, BoolExpr, CharExpr, InstVarExpr, IntegerExpr, JNullExpr, LocalOrFieldVarExpr, StmtExprExpr, SuperExpr, ThisExpr, UnaryExpr, LocalVar, FieldVar {
    public Type type;
}
