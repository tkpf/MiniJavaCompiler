package syntaxtree.statements;

import syntaxtree.Type;

public final class VarDeclStmt extends Statement {

    public final String name;

    public VarDeclStmt(String name, Type type) {
            this.name = name;
            this.type = type;
    }

    @Override
    public String toString() {
        return "(VarDecl " + name + " " + type + ")";
    }
}
