package syntaxtree;

import syntaxtree.expressions.Expression;
import syntaxtree.expressions.LocalOrFieldVarExpr;
import syntaxtree.expressions.Type;
import syntaxtree.statementexpressions.AssignStmtExpr;
import syntaxtree.statementexpressions.MethodCallStmtExpr;
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
    public static MethodCallStmtExpr ast3 = new MethodCallStmtExpr(new LocalOrFieldVarExpr("x"), "f", new Vector<Expression>());

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
    public static Vector<Field> fields2 = new Vector<>( Arrays.asList( new Field("i", new Type("int")) ));
    public static BlockStmt meth1block = new BlockStmt(new Vector<Statement>( Arrays.asList(
            new LocalVarDeclStmt("v", new Type("int")),
            new StmtExprStmt( new AssignStmtExpr( new LocalOrFieldVarExpr("i"), new LocalOrFieldVarExpr("v")) ),
            new ReturnStmt(null)
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
}
