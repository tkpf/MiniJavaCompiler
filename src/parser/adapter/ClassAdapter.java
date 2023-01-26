package parser.adapter;

import syntaxtree.Class;
import parser.production.JavaMiniParser;
import syntaxtree.Field;
import syntaxtree.Method;
import syntaxtree.statements.BlockStmt;
import syntaxtree.statements.Statement;
import syntaxtree.statements.VarDeclStmt;

import java.util.Vector;


public class ClassAdapter {

    public static Class adapt(JavaMiniParser.ClassDeclarationContext ctx) {
        // modifier get ignored
        // inheritance get ignored

        // load name
        // TODO try catch
        final String name = ctx.Identifier().getText();
        // load members
        Vector<JavaMiniParser.MemberContext> members = new Vector<>();
        for (JavaMiniParser.ClassBodyDeclarationContext classbodydeclaration : ctx.classBody().classBodyDeclaration()) {
            members.add(classbodydeclaration.member());
        }
        //load fields and methods
        Vector<Method> methods = new Vector<>();
        Vector<Statement> stmts = new Vector<>();

        for(JavaMiniParser.MemberContext member: members) {
            if (member.fieldDeclaration() != null) {
                Statement fieldStmt;
                //check if direct initialization takes place
                if (member.fieldDeclaration().variableDeclarator().directInitialization() != null) {
                    fieldStmt = FieldAdapter
                            .adapt(member.fieldDeclaration(), true);
                }
                else {
                    fieldStmt =  FieldAdapter
                            .adapt(member.fieldDeclaration(), false);
                }
                stmts.add(fieldStmt);
            }
            else if (member.methodDeclaration() != null) {
                Method m = MethodAdapter.adapt(member.methodDeclaration());
                methods.add(m);
            }
            /*
            else if (member.constructorDeclaration() != null) {
                // implement constructor declaration
            }
            else if (member.classDeclaration() != null) {
                // implement class declaration
            }
            */

            else  {
                return null; // can never be reached
            }

        }

        //return Instance
        return new Class(name, stmts, methods);
    }


}
