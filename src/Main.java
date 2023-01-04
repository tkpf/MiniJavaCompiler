import syntaxtree.*;
import syntaxtree.Class;

import java.util.Arrays;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {

        // Examples for abstract syntax:

        /*
            class TestKlasse {
                int v;
            }
        */
        Vector<Field> fields1 = new Vector<Field>();
        fields1.addElement(new Field("v", "int"));
        Class ast1 = new Class("TestKlasse", fields1, new Vector<Method>());

        /*
            void methode (int x, char y) { }
        */
        Method ast2 = new Method("methode", new TypeExpr("void"), new Vector<Parameter>(), new BlockStmt(null));

        /*
            x.f();
        */
        MethodCallStmtExpr ast3 = new MethodCallStmtExpr(new LocalOrFieldVarExpr("x"), "f", new Vector<Expression>());

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
        Vector<Field> fields2 = new Vector<>( Arrays.asList( new Field("i", "int") ));
        BlockStmt meth1block = new BlockStmt(new Vector<Statement>( Arrays.asList(
                new LocalVarDeclStmt("v", new TypeExpr("int")),
                new StmtExprStmt( new AssignStmtExpr( new LocalOrFieldVarExpr("i"), new LocalOrFieldVarExpr("v")) ),
                new ReturnStmt(null)
        )));
        Method meth1 = new Method(
                "methode",
                new TypeExpr("int"),
                new Vector<Parameter>( Arrays.asList(
                        new Parameter("x", new TypeExpr("Typ")),
                        new Parameter("y", new TypeExpr("int")),
                        new Parameter("z", new TypeExpr("int")))),
                meth1block);
        Class ast5 = new Class(
                "TestKlasse",
                fields2,
                new Vector<Method>(Arrays.asList( meth1 )));
    }
}
