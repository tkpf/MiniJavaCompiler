package syntaxtree;

import syntaxtree.expressions.*;
import syntaxtree.statementexpressions.AssignStmtExpr;
import syntaxtree.statementexpressions.MethodCallStmtExpr;
import syntaxtree.statementexpressions.StatementExpression;
import syntaxtree.statements.*;

import java.util.Arrays;
import java.util.Vector;

public class Examples {

    // Examples for abstract syntax:

    /*
        class TestKlasse {
            int v;
        }
    */
    public static Vector<Field> fields1 = new Vector<>(Arrays.asList( new Field("v", new Type("int")) ));
    public static Class ast1 = new Class("TestKlasse", fields1, new Vector<Method>());

    /*
        void methode (int x, char y) { }
    */
    public static Method ast2 = new Method("methode", new Type("void"), new Vector<Parameter>(), new BlockStmt(null));

    /*
        x.f();
    */
    //public static MethodCallStmtExpr ast3 = new MethodCallStmtExpr(new LocalOrFieldVarExpr("x"), "f", new Vector<Expression>());

        /*
            return 1 + x;
        */
    //ReturnStmt ast4 = new ReturnStmt( new BinaryExpr(IntLiteral(1), new LocalOrFieldVarExpr("x"), "+" ) );

    /*
        class TestKlasse {
            int v;
            int methode (Typ x, int y, int z)
            {
                int i;
                i = v;
                return i;
            }
        }
    */
    public static Vector<Field> fields2 = new Vector<>( Arrays.asList( new Field("v", new Type("int")) ));
    public static BlockStmt meth1block = new BlockStmt(new Vector<Statement>( Arrays.asList(
            new LocalVarDeclStmt("i", new Type("int")),
            new StmtExprStmt( new AssignStmtExpr( new LocalVar("i"), new FieldVar("v")) ),
            new ReturnStmt(new LocalVar("z"))
    )));
    public static Method meth1 = new Method(
            "methode",
            new Type("int"),
            new Vector<Parameter>( Arrays.asList(
                    new Parameter("x", new Type("Typ")),
                    new Parameter("y", new Type("int")),
                    new Parameter("z", new Type("int")))),
            meth1block);
    public static Class ast5 = new Class(
            "TestKlasse",
            fields2,
            new Vector<Method>(Arrays.asList( meth1 )));

    /*
        classe TestKlasse2 {
            int ret1() { return 1; }
        }
    */
    public static Method meth2 = new Method(
            "ret100000",
            new Type("int"),
            new Vector<Parameter>(),
            new BlockStmt(new Vector<Statement>(Arrays.asList(
                    new ReturnStmt(
                            new BinaryExpr(
                                    new IntegerExpr(1),
                                    new IntegerExpr(2),
                                "+") )
            )))
    );
    public static Method meth3 = new Method(
            "retstr",
            new Type("String"),
            new Vector<Parameter>(),
            new BlockStmt(new Vector<Statement>(Arrays.asList(
                    new ReturnStmt(new BinaryExpr( new StringExpr("hello"),  new StringExpr("universe"), "+"))
            )))
    );

    public static Method meth4 = new Method(
            "iftest",
            new Type("int"),
            new Vector<Parameter>(),
            new BlockStmt(new Vector<Statement>(Arrays.asList(
                    new IfStmt(
                            new UnaryExpr(new BoolExpr(true), "not"),
                            new BlockStmt(new Vector<Statement>(Arrays.asList( new ReturnStmt(new IntegerExpr(1)) ))),
                            new BlockStmt(new Vector<Statement>(Arrays.asList( new ReturnStmt(new IntegerExpr(2)) )))
                    )
            )))
    );

    public static Method meth5 = new Method(
            "add",
            new Type("int"),
            new Vector<Parameter>(Arrays.asList(
                    new Parameter("a", new Type("int")),
                    new Parameter("b", new Type("int")))),
            new BlockStmt(new Vector<Statement>(Arrays.asList(
                    new LocalVarDeclStmt("result", new Type("int")),
                    new StmtExprStmt(new AssignStmtExpr(new LocalVar("result"),
                            new BinaryExpr(
                            new LocalVar("a"),
                            new LocalVar("b"),
                            "+"
                    ))),
                    new ReturnStmt(new LocalVar("result"))
            )))
    );
    public static Class ast6 = new Class(
            "TestKlasse2",
            fields1,
            new Vector<Method>(Arrays.asList( meth2, meth3, meth4, meth5 )));
}
