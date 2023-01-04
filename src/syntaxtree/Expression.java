package syntaxtree;

public abstract sealed class Expression permits TypeExpr, ThisExpr, SuperExpr, InstVarExpr, LocalOrFieldVarExpr, BinaryExpr, UnaryExpr, StmtExprExpr {

    public void codeGen() {
        //todo implement codeGen
    }

}
