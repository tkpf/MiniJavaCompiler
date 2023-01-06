package syntaxtree.statements;

import syntaxtree.expressions.Type;

public final class LocalVarDeclStmt extends Statement {

    private final String name;
    private final Type type;

    public LocalVarDeclStmt(String name, Type type) {
            this.name = name;
            this.type = type;
    }

}
