package syntaxtree;

public final class LocalVarDeclStmt extends Statement{

    private final String name;
    private final TypeExpr type;

    public LocalVarDeclStmt(String name, TypeExpr type) {
            this.name = name;
            this.type = type;
    }

}
