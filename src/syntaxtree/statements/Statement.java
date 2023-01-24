package syntaxtree.statements;

import syntaxtree.Type;

public abstract sealed class Statement permits BlockStmt, ReturnStmt, IfStmt, WhileStmt, VarDeclStmt, StmtExprStmt {

        public Type type;
        private void codeGen() {
            //todo implement codeGen
        }

        @Override
        public String toString() {
                return "{" + type + "}";
        }
}
