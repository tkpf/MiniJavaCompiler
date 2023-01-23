package syntaxtree.statements;

import syntaxtree.AST;
import syntaxtree.Type;

public abstract sealed class Statement extends AST permits BlockStmt, ReturnStmt, IfStmt, WhileStmt, LocalVarDeclStmt, StmtExprStmt {

        public Type type;
        private void codeGen() {
            //todo implement codeGen
        }

        @Override
        public String toString() {
                return "{" + type + "}";
        }
}
