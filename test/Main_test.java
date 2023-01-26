import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import parser.adapter.ProgramAdapter;
import parser.production.JavaMiniLexer;
import parser.production.JavaMiniParser;
import syntaxtree.Program;

import typecheck.exceptions.AlreadyDefinedException;
import typecheck.exceptions.MissingSymbolException;
import typecheck.exceptions.TypeMismatchException;

import java.io.IOException;

public class Main_test {

    public static void main(String[] args)
            throws IOException, MissingSymbolException, AlreadyDefinedException, TypeMismatchException {

        String basicTest = "test_basicClasses.txt";
        String elevatedTest = "test_ProgrammAboutShapes.txt";

        System.out.println("Running Main_test");

        CharStream input = CharStreams.fromFileName("./test/test3.txt");
        JavaMiniLexer lexer = new JavaMiniLexer(input);
        JavaMiniParser parser = new JavaMiniParser(new CommonTokenStream(lexer));

        System.out.print("parser output: ");
        //System.out.println(parser.compilationUnit().toStringTree(parser));

        Program prgm = ProgramAdapter.adapt(parser.compilationUnit());
        System.out.println("Abstract syntax was generated!");

        // If you want to have a StringTree output in the console please comment the 2 above lines when constructing object prgm, because this makes the parser object unusable.
        //System.out.print("parser output: ");
        //System.out.println(parser.compilationUnit().toStringTree(parser));



        //TypeCheck typeCheck = new TypeCheck(prgm);
        //System.out.println(typeCheck.env.fields + "\n" + typeCheck.env.methods);
        //typeCheck.check();
        //System.out.print(prgm);
    }



}
