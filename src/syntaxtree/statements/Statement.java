package syntaxtree.statements;

import syntaxtree.statements.*;

public abstract sealed class Statement permits BlockStmt, ReturnStmt, IfStmt, WhileStmt, LocalVarDeclStmt, StmtExprStmt {

        public String type = "";
        private void codeGen() {
            //todo implement codeGen
        }

}
