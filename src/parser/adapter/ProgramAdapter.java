package parser.adapter;

import parser.production.JavaMiniParser;
import syntaxtree.Class;
import syntaxtree.Program;

import java.util.Vector;

public class ProgramAdapter {
    public static Program adapt (JavaMiniParser.CompilationUnitContext prgm) {
        Vector<Class> classes = new Vector<>();
        for (JavaMiniParser.TypeDeclarationContext decCtxt :  prgm.typeDeclaration()) {
            classes.add(
                    ClassAdapter.adapt(decCtxt.classDeclaration())
            );
        }
        return new Program(classes);
    }
}
