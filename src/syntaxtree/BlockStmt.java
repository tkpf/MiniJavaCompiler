package syntaxtree;

import java.util.Vector;

public final class BlockStmt extends Statement{

    private final Vector<Statement> stmtBlck;

    public BlockStmt(Vector<Statement> stmts) {
        this.stmtBlck = stmts;
    }

}
