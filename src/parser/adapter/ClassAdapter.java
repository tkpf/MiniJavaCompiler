package parser.adapter;

import syntaxtree.Class;
import parser.production.JavaMiniParser;
import syntaxtree.Field;
import syntaxtree.Method;

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
        Vector<Field> fields = new Vector<>();

        for(JavaMiniParser.MemberContext member: members) {
            if (member.fieldDeclaration() != null) {
                Field f = FieldAdapter.adapt(member.fieldDeclaration());
                fields.add(f);
            }
            else if (member.methodDeclaration() != null) {
                Method m = MethodAdapter.adapt(member.methodDeclaration());
                methods.add(m);
            }
            else if (member.constructorDeclaration() != null) {
                // todo implement constructor declaration
            }
            else if (member.classDeclaration() != null) {
                // todo implement class declaration
            }
            else  // can never be reached
                // TODO raise error
                return null;
        }

        //return Instance
        return new Class(name, fields, methods);
    }


}
