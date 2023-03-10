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
import java.util.Optional;
import java.util.Vector;

public class TypeCheck {

    public final Program prgm;
    public final GlobalScope global;

    public TypeCheck(Program prgm)
            throws MissingSymbolException, AlreadyDefinedException {
        this.prgm = prgm;
        // constructor populates global scope from untyped program AST
        this.global = new GlobalScope(prgm);
    }

    public void check() throws TypeMismatchException, MissingSymbolException, AlreadyDefinedException {
        for (Class c : prgm.classes) {
            for (Field f : c.fields) {
                if (f.assignment != null) {
                    typeStatementExpression(f.assignment, new LocalScope(c.name), false);
                }
            }
            for (Method m : c.meths) {
                LocalScope localScope = new LocalScope(c.name);
                for (Parameter p : m.params) {
                    localScope.addField(p.name, p.type);
                }
                Type methodBodyType = typeStatement(m.blck, localScope);
                // body of constructors must be of type `void`
                if (m.type.equals(m.name)) {
                    if (!methodBodyType.equals("void")) {
                        throw new TypeMismatchException(methodBodyType.toString());
                    }
                } else if (!m.type.equals(methodBodyType)) {
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
                exp.type = global.lookupField(inst, instVarExpr.name);
            }
            case LocalOrFieldVarExpr loFVarExpr -> {
                Optional<Type> localVarType = localScope.lookupField(loFVarExpr.name);
                    if (localVarType.isPresent()) {
                        loFVarExpr.context = LocalOrFieldVarExpr.VarType.local;
                        exp.type = localVarType.get();
                    } else {                                   // this might be a future issue for nested classes
                        Type fieldVarType = global.lookupField(localScope.getCurrentClass(), loFVarExpr.name);
                        loFVarExpr.context = LocalOrFieldVarExpr.VarType.field;
                        exp.type = fieldVarType;
                }
            }
            case StmtExprExpr stmtExprExpr -> {
                exp.type = typeStatementExpression(stmtExprExpr.stmtExprExpr, localScope, true);
            }
            case ThisExpr thisExpr -> {
                exp.type = localScope.getCurrentClass();
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
        }
        return exp.type;
    }

    public Type typeStatement(Statement stmt, LocalScope localScope)
            throws TypeMismatchException, MissingSymbolException, AlreadyDefinedException {
        switch (stmt) {
            case BlockStmt blockStmt -> {
                ArrayList<Type> types = new ArrayList<>(blockStmt.stmtBlck.size());
                for (Statement s : blockStmt.stmtBlck) {
                    Type stmtType = typeStatement(s, localScope);
                    // ignore type of `VarDeclStmt` for block type deduction
                    if (!(s instanceof VarDeclStmt)) {
                        types.add(stmtType);
                    }
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
                if (returnStmt.rExpr == null) {
                    stmt.type = new Type("void");
                } else {
                    stmt.type = typeExpression(returnStmt.rExpr, localScope);
                }
            }
            case IfStmt ifStmt -> {
                if (!typeExpression(ifStmt.boolExpr, localScope).equals("boolean")) {
                    throw new TypeMismatchException();
                }
                Type ifType = typeStatement(ifStmt.ifBlck, localScope);
                if (ifStmt.elseBlck == null) {
                    stmt.type = ifType;
                } else {
                    Type elseType = typeStatement(ifStmt.elseBlck, localScope);
                    if (ifType.equals(elseType)) {
                        stmt.type = ifType;
                    } else {
                        throw new TypeMismatchException();
                    }
                }
            }
            case WhileStmt whileStmt -> {
                if (!typeExpression(whileStmt.boolExpr, localScope).equals("boolean")) {
                    throw new TypeMismatchException();
                }
                stmt.type = typeStatement(whileStmt.blck, localScope);
            }
            case StmtExprStmt stmtExprStmt -> {
                stmt.type = typeStatementExpression(stmtExprStmt.stmtExpr, localScope, false);
            }
            case VarDeclStmt varDeclStmt -> {
                localScope.addField(varDeclStmt.name, varDeclStmt.type);
                // type already set by parser adapter
            }
        }
        return stmt.type;
    }
    public Type typeStatementExpression(StatementExpression stmtExp, LocalScope localScope, boolean fromAssign)
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
                ArrayList<Type> paramTypes = new ArrayList<>(newStmtExpr.initParams.size());
                for (Expression e : newStmtExpr.initParams) {
                    paramTypes.add(typeExpression(e, localScope));
                }
                Signature constSignature = new Signature(newStmtExpr.name, paramTypes);
                // `newStmtExpr.name` equals its type
                Type innerType = global.lookupMethod(new Type(newStmtExpr.name), constSignature);
                // type of `NewStmtExpr` always `void`
                stmtExp.type = new Type("void");
                // but if coming from an assignment context return "inner type",
                //meaning the class that is being instantiated to the
                //encapsulating `StmtExprExpr`
                if (fromAssign) return innerType;
            }
            case MethodCallStmtExpr methodCallStmtExpr -> {
                if (methodCallStmtExpr.obj == null) {
                    methodCallStmtExpr.obj = new ThisExpr();
                }
                Type objType = typeExpression(methodCallStmtExpr.obj, localScope);
                ArrayList<Type> paramTypes = new ArrayList<>(methodCallStmtExpr.methParams.size());
                for (Expression exp : methodCallStmtExpr.methParams) {
                    paramTypes.add(typeExpression(exp, localScope));
                }
                Signature methodSignature = new Signature(methodCallStmtExpr.meth, paramTypes);
                methodCallStmtExpr.innerType = global.lookupMethod(objType, methodSignature);
                stmtExp.type = new Type("void");
                if (fromAssign) return methodCallStmtExpr.innerType;
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
                    if ((t1.equals("int") || t1.equals("char")) && t1.equals(t2)) {
                        binaryExpr.type = t1;
                    } else {
                        throw new TypeMismatchException();
                    }
                }
                case "<", "<=", ">=", ">" -> {
                    if ((t1.equals("int") || t1.equals("char")) && t1.equals(t2)) {
                        binaryExpr.type = new Type("boolean");
                    } else {
                        throw new TypeMismatchException();
                    }
                }
                case "==", "!=" -> {
                    if (t1.equals(t2) || t1.equals("null") || t2.equals("null")) {
                        binaryExpr.type = new Type("boolean");
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
                case default -> throw new MissingSymbolException(binaryExpr.eval);
            }
        }
    }

    public String getGlobalScope() {
        return global.toString();
    }
}
