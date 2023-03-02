package parser.adapter;

import parser.exceptions.EscapeHatchException;
import syntaxtree.Class;
import parser.production.JavaMiniParser;
import syntaxtree.Field;
import syntaxtree.Method;
import java.util.Vector;


public class ClassAdapter {

    public static Class adapt(JavaMiniParser.ClassDeclarationContext ctx) throws EscapeHatchException {
        // modifier get ignored
        // inheritance get ignored

        // load name
        final String name = ctx.Identifier().getText();

        // load members
        Vector<JavaMiniParser.MemberContext> members = new Vector<>();
        for (JavaMiniParser.ClassBodyDeclarationContext classBodyDeclaration : ctx.classBody().classBodyDeclaration()) {
            if (classBodyDeclaration.member() != null) {
                members.add(classBodyDeclaration.member());
            }
            else {
                // empty line with semicolon
            }
        }
        // load fields and methods
        Vector<Method> methods = new Vector<>();
        Vector<Field> fields = new Vector<>();

        for(JavaMiniParser.MemberContext member: members) {
            if (member.fieldDeclaration() != null) {
                Field field;
                //check if direct initialization takes place
                if (member.fieldDeclaration().variableDeclarator().directInitialization() != null) {
                    field = FieldAdapter
                            .adapt(member.fieldDeclaration(), true);
                }
                else {
                    field =  FieldAdapter
                            .adapt(member.fieldDeclaration(), false);
                }
                fields.add(field);
            }
            else if (member.methodDeclaration() != null) {
                Method m = MethodAdapter.adapt(member.methodDeclaration());
                methods.add(m);
            }

            else  {
                // should never be reached
                throw new EscapeHatchException();
            }

        }

        //return Instance
        return new Class(name, fields, methods);
    }


}
