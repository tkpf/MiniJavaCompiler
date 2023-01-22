package syntaxtree.statements;

import syntaxtree.Type;

public final class LocalVarDeclStmt extends Statement {

    public final String name;

    public LocalVarDeclStmt(String name, Type type) {
            this.name = name;
            this.type = type;
    }

    @Override
    public String toString() {
        return "(LVarDecl " + this.name + " " + this.type + ")";
    }
}
