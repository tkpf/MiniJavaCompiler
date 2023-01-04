package parser.adapter;

import parser.production.JavaMiniParser;
import syntaxtree.BlockStmt;
import syntaxtree.Statement;

import java.util.Vector;

public class BlockStmtAdapter {
    final static BlockStmt adapt(JavaMiniParser.BlockContext ctx) {

        Vector<Statement> stmts = new Vector<>();

        for (JavaMiniParser.BlockStatementContext stmt : ctx.blockStatement()) {

        }

        return new BlockStmt(stmts)
    }
}
