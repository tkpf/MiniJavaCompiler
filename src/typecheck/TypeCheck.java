package typecheck;

import syntaxtree.*;
import syntaxtree.Class;
import syntaxtree.expressions.*;
import syntaxtree.statements.*;
import syntaxtree.statementexpressions.*;
import typecheck.exceptions.AlreadyDefinedException;
import typecheck.exceptions.MissingSymbolException;
import typecheck.exceptions.TypeMismatchException;

import java.util.ArrayList;
import java.util.Vector;

public class TypeCheck {

    public Program prgm;
    public Environment env;

    public TypeCheck(Program prgm)
            throws MissingSymbolException, AlreadyDefinedException {
        this.prgm = prgm;
        this.env = new Environment(prgm);
    }

    public void check() throws TypeMismatchException, MissingSymbolException, AlreadyDefinedException {
        for (Class c : prgm.classes) {
            for (Field f : c.fields) {
                if (f.assignment != null) {
                    typeStatementExpression(f.assignment, new LocalScope(c.name));
                }
            }
            for (Method m : c.meths) {
                LocalScope localScope = new LocalScope(c.name);
                for (Parameter p : m.params) {
                    localScope.addField(p.name, p.type);
                }
                Type methodBodyType = typeStatement(m.blck, localScope);
                if (!m.type.equals(methodBodyType)) {
                    throw new TypeMismatchException(methodBodyType.toString());
                }
            }
        }
    }

    public Type typeExpression(Expression exp, LocalScope localScope)
            throws TypeMismatchException, MissingSymbolException {
        switch (exp) {
            case BoolExpr    e -> exp.type = new Type("boolean");
            case CharExpr    e -> exp.type = new Type("char");
            case IntegerExpr e -> exp.type = new Type("int");
            case JNullExpr   e -> exp.type = new Type("null");
            case StringExpr  e -> exp.type = new Type("String");

            case BinaryExpr binaryExpr -> {
                typeBinaryExpression(binaryExpr, localScope);
            }
            case InstVarExpr instVarExpr -> {
                Type inst = typeExpression(instVarExpr.inst, localScope);
                exp.type = env.lookupField(inst, instVarExpr.name);
            }
            case LocalOrFieldVarExpr loFVarExpr -> {
                Type varType;
                try {
                    varType = localScope.lookupField(loFVarExpr.name);
                    loFVarExpr.context = LocalOrFieldVarExpr.VarType.local;
                    exp.type = varType;
                } catch (MissingSymbolException localMissing) {
                    varType = env.lookupField(localScope.thisClass, loFVarExpr.name);
                    loFVarExpr.context = LocalOrFieldVarExpr.VarType.field;
                    exp.type = varType;
                }
            }
            case StmtExprExpr stmtExprExpr -> {
                exp.type = typeStatementExpression(stmtExprExpr.stmtExprExpr, localScope);
            }
            case SuperExpr superExpr -> {
                exp.type = new Type("Object");
            }
            case ThisExpr thisExpr -> {
                exp.type = localScope.thisClass;
            }
            case UnaryExpr unaryExpr -> {
                Type t1 = typeExpression(unaryExpr.expr, localScope);
                switch (unaryExpr.eval) {
                    case "!" -> {
                        if (t1.equals("boolean")) {
                            exp.type = t1;
                        } else {
                            throw new TypeMismatchException();
                        }
                    }
                    case "+", "-", "++", "--" -> {
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

    public Type typeStatement(Statement stmt, LocalScope localScope)
            throws TypeMismatchException, MissingSymbolException, AlreadyDefinedException {
        switch (stmt) {
            case BlockStmt blockStmt -> {
                int m = blockStmt.stmtBlck.size();
                Vector<Type> types = new Vector<>(m);
                for (Statement s : blockStmt.stmtBlck) {
                    types.add(typeStatement(s, localScope));
                }
                Type resultType = new Type("void");
                for (Type t : types) {
                    if (resultType.equals("void")) {
                        resultType = t;
                    } else if (t.equals("void")) {
                        // do nothing
                    } else if (!resultType.equals(t)) {
                        throw new TypeMismatchException(t.name);
                    } // else types match -> do nothing
                }
                stmt.type = resultType;
            }
            case ReturnStmt returnStmt -> {
                stmt.type = typeExpression(returnStmt.rExpr, localScope);
            }
            case IfStmt ifStmt -> {
                if (!typeExpression(ifStmt.boolExpr, localScope).equals("boolean")) {
                    throw new TypeMismatchException();
                }
                Type ifType = typeStatement(ifStmt.ifBlck, localScope);
                Type elseType = typeStatement(ifStmt.elseBlck, localScope);
                if (elseType == null || ifType.equals(elseType)) {
                    stmt.type = ifType;
                } else {
                    throw new TypeMismatchException();
                }
            }
            case WhileStmt whileStmt -> {
                if (!typeExpression(whileStmt.boolExpr, localScope).equals("boolean")) {
                    throw new TypeMismatchException();
                }
                stmt.type = typeStatement(whileStmt.blck, localScope);
            }
            case StmtExprStmt stmtExprStmt -> {
                stmt.type = typeStatementExpression(stmtExprStmt.stmtExpr, localScope);
            }
            case VarDeclStmt varDeclStmt -> {
                localScope.addField(varDeclStmt.name, varDeclStmt.type);
                stmt.type = new Type("void");
            }
        }
        return stmt.type;
    }
    public Type typeStatementExpression(StatementExpression stmtExp, LocalScope localScope)
            throws MissingSymbolException, TypeMismatchException {
        switch (stmtExp) {
            case AssignStmtExpr assignStmtExpr -> {
                Type left = typeExpression(assignStmtExpr.as2Expr, localScope);
                Type right = typeExpression(assignStmtExpr.asFromExpr, localScope);
                if (left.equals(right)) {
                    stmtExp.type = new Type("void");
                } else {
                    throw new TypeMismatchException();
                }
            }
            case NewStmtExpr newStmtExpr -> {
                // TODO: new Integer, Char, Boolean, String, etc deprecated
                stmtExp.type = new Type("void");
                // TODO: check if constructor signature has been defined
            }
            case MethodCallStmtExpr methodCallStmtExpr -> {
                Type objType = typeExpression(methodCallStmtExpr.obj, localScope);
                ArrayList<Type> paramTypes = new ArrayList<>(methodCallStmtExpr.methParams.size());
                for (Expression exp : methodCallStmtExpr.methParams) {
                    paramTypes.add(typeExpression(exp, localScope));
                }
                Signature methodSignature = new Signature(methodCallStmtExpr.meth, paramTypes);
                stmtExp.type = env.lookupMethod(objType, methodSignature);
            }
        }
        return stmtExp.type;
    }

    private void typeBinaryExpression(BinaryExpr binaryExpr, LocalScope localScope)
            throws TypeMismatchException, MissingSymbolException {
        Type t1 = typeExpression(binaryExpr.expr1, localScope);
        Type t2 = typeExpression(binaryExpr.expr2, localScope);

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
