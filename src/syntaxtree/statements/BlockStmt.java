package syntaxtree.statements;

import java.util.Vector;

public final class BlockStmt extends Statement {

    public final Vector<Statement> stmtBlck;

    public BlockStmt(Vector<Statement> stmts) {
        this.stmtBlck = stmts;
    }

}
