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

    public void check() throws TypeMismatchException, MissingSymbolException {
        for (Class c : prgm.classes) {
            for (Method m : c.meths) {
                typeStatement(m.blck);
            }
        }
    }

    public Type typeExpression(Expression exp) throws TypeMismatchException, MissingSymbolException {
        switch (exp) {
            case BoolExpr    e -> exp.type = new Type("boolean");
            case CharExpr    e -> exp.type = new Type("char");
            case IntegerExpr e -> exp.type = new Type("int");
            case JNullExpr   e -> exp.type = new Type("null");
            case StringExpr  e -> exp.type = new Type("String");

            case BinaryExpr binaryExpr -> {
                typeBinaryExpression(binaryExpr);
            }
            case InstVarExpr instVarExpr -> {

            }
            case LocalOrFieldVarExpr localOrFieldVarExpr -> {
                exp.type = new Type("int");
            }
            case StmtExprExpr stmtExprExpr -> {
                exp.type = typeStatementExpression(stmtExprExpr.stmtExprExpr);
            }
            case SuperExpr superExpr -> {
            }
            case ThisExpr thisExpr -> {
            }
            case UnaryExpr unaryExpr -> {
                Type t1 = typeExpression(unaryExpr.expr);
                switch (unaryExpr.eval) {
                    case "!" -> {
                        if (t1.equals("boolean")) {
                            exp.type = t1;
                        } else {
                            throw new TypeMismatchException();
                        }
                    }
                    case "++", "--" -> {
                        if (t1.equals("int")) {
                            exp.type = t1;
                        } else {
                            throw new TypeMismatchException();
                        }
                    }
                    default -> throw new MissingSymbolException();
                }
            }
            case LocalVar localVar -> {
            }
            case FieldVar fieldVar -> {
            }
        }
        return exp.type;
    }

    public Type typeStatement(Statement stmt) throws TypeMismatchException, MissingSymbolException {
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
                if (!typeExpression(ifStmt.boolExpr).equals("boolean")) {
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
                if (!typeExpression(whileStmt.boolExpr).equals("boolean")) {
                    throw new TypeMismatchException();
                }
                stmt.type = typeStatement(whileStmt.blck);
            }
            case LocalVarDeclStmt localVarDeclStmt -> {
            }
            case StmtExprStmt stmtExprStmt -> {
                stmt.type = typeStatementExpression(stmtExprStmt.stmtExpr);
            }
        }
        return stmt.type;
    }
    public Type typeStatementExpression(StatementExpression stmtExp)
            throws MissingSymbolException, TypeMismatchException {
        HashMap<String, Type> localEnv;
        switch (stmtExp) {
            case AssignStmtExpr assignStmtExpr -> {
                Type left = typeExpression(assignStmtExpr.as2Expr);
                Type right = typeExpression(assignStmtExpr.asFromExpr);
                if (left.equals(right)) {
                    stmtExp.type = left;
                } else {
                    throw new TypeMismatchException();
                }
            }
            case NewStmtExpr newStmtExpr -> {
            }
            case MethodCallStmtExpr methodCallStmtExpr -> {
            }
        }
        return stmtExp.type;
    }

    private void typeBinaryExpression(BinaryExpr binaryExpr)
            throws TypeMismatchException, MissingSymbolException {
        Type t1 = typeExpression(binaryExpr.expr1);
        Type t2 = typeExpression(binaryExpr.expr2);

        if (t1.equals("String") && t2.equals("String") && binaryExpr.eval.equals("+")) {
            binaryExpr.type = t1;
        } else {
            switch (binaryExpr.eval) {
                case "+", "-", "*", "/", "%" -> {
                    // TODO: typecasting?
                    //if (t2.equals("String") && t1.equals("int") || t1.equals("char"))
                    if ((t1.equals("int") || t1.equals("char")) && t1.equals(t2)) {
                        binaryExpr.type = t1;
                    } else {
                        throw new TypeMismatchException();
                    }
                }
                case "&&", "||" -> {
                    if (t1.equals("boolean") && t1.equals(t2)) {
                        binaryExpr.type = t1;
                    } else {
                        throw new TypeMismatchException();
                    }
                }
                case default -> throw new MissingSymbolException();
            }
        }
    }
}
