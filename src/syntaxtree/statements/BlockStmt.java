package syntaxtree.statements;

import java.util.Vector;

public final class BlockStmt extends Statement {

    public final Vector<Statement> stmtBlck;

    public BlockStmt(Vector<Statement> stmts) {
        this.stmtBlck = stmts;
    }

    @Override
    public String toString() {
        String result = "(Block" + super.toString() + "[";
        for (Statement s : stmtBlck) {
            result += s.toString() + " ";
        }
        if (stmtBlck.size() > 0) result = result.substring(0, result.length() - 1);
        result += "])";
        return result;
    }
}
