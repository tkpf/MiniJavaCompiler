package syntaxtree.statements;

import syntaxtree.Type;

public abstract sealed class Statement
        permits BlockStmt, ReturnStmt, IfStmt, WhileStmt, VarDeclStmt, StmtExprStmt {

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
