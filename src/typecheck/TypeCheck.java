package typecheck;

import syntaxtree.*;
import syntaxtree.Class;
import syntaxtree.expressions.*;
import syntaxtree.statements.*;
import syntaxtree.statementexpressions.*;
import typecheck.exceptions.AlreadyDefinedException;
import typecheck.exceptions.MissingSymbolException;
import typecheck.exceptions.TypeMismatchException;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Vector;

public class TypeCheck {

    public Program prgm;
    public Environment env;

    public TypeCheck(Program prgm)
            throws MissingSymbolException, AlreadyDefinedException {
        this.prgm = prgm;
        this.env = new Environment(prgm);
    }

    public void check() throws TypeMismatchException {
        for (Class c : prgm.classes) {
            for (Method m : c.meths) {
                typeStatement(m.blck);
            }
        }
    }

    public Type typeExpression(Expression exp) {
        switch (exp) {
            case BoolExpr    e -> exp.type = new Type("bool");
            case CharExpr    e -> exp.type = new Type("char");
            case IntegerExpr e -> exp.type = new Type("int");
            case JNullExpr   e -> exp.type = new Type("null");
            case StringExpr  e -> exp.type = new Type("String");

            case BinaryExpr binaryExpr -> {
                typeExpression(binaryExpr.expr1);
                typeExpression(binaryExpr.expr2);

            }
            case InstVarExpr instVarExpr -> {
            }
            case LocalOrFieldVarExpr localOrFieldVarExpr -> {
            }
            case StmtExprExpr stmtExprExpr -> {
            }
            case SuperExpr superExpr -> {
            }
            case ThisExpr thisExpr -> {
            }
            case UnaryExpr unaryExpr -> {
            }
            case LocalVar localVar -> {
            }
            case FieldVar fieldVar -> {
            }
        }
        return exp.type;
    }

    public Type typeStatement(Statement stmt) throws TypeMismatchException {
        switch (stmt) {
            case BlockStmt blockStmt -> {
                int m = blockStmt.stmtBlck.size();
                Vector<Type> types = new Vector<>(m);
                for (Statement s : blockStmt.stmtBlck) {
                    types.add(typeStatement(s));
                }
                stmt.type = types.lastElement();
            }
            case ReturnStmt returnStmt -> {
                stmt.type = typeExpression(returnStmt.rExpr);
            }
            case IfStmt ifStmt -> {
                if (!typeExpression(ifStmt.boolExpr).equals("bool")) {
                    throw new TypeMismatchException();
                }
                Type ifType = typeStatement(ifStmt.ifBlck);
                Type elseType = typeStatement(ifStmt.elseBlck);
                if (elseType.equals("null") || ifType.equals(elseType)) {
                    stmt.type = ifType;
                } else {
                    throw new TypeMismatchException();
                }
            }
            case WhileStmt whileStmt -> {
                if (!typeExpression(whileStmt.boolExpr).equals("bool")) {
                    throw new TypeMismatchException();
                }
                stmt.type = typeStatement(whileStmt.blck);
            }
            case LocalVarDeclStmt localVarDeclStmt -> {
            }
            case StmtExprStmt stmtExprStmt -> {
            }
        }
        return stmt.type;
    }
    public void typeStatementExpression(StatementExpression stmtExp) {
        switch (stmtExp) {

            case AssignStmtExpr assignStmtExpr -> {
            }
            case NewStmtExpr newStmtExpr -> {
            }
            case MethodCallStmtExpr methodCallStmtExpr -> {
            }
        }
    }
}
