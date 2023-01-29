package syntaxtree.statements;

import java.util.Vector;

public final class BlockStmt extends Statement {

    public final Vector<Statement> stmtBlck;

    public BlockStmt(Vector<Statement> stmts) {
        this.stmtBlck = stmts;
    }

    @Override
    public String toString() {
        String result = "[Block";
        for (Statement s : stmtBlck) {
            result += s.toString() + " ";
        }
        result += "]";
        return result;
    }
}
