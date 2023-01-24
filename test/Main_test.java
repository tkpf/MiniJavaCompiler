import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import parser.adapter.ClassAdapter;
import parser.adapter.ProgramAdapter;
import parser.production.JavaMiniLexer;
import parser.production.JavaMiniParser;
import syntaxtree.Class;
import syntaxtree.Program;

import java.io.IOException;

public class Main_test {

    public static void main(String[] args) throws IOException  {

        System.out.println("Running Main_test");
        CharStream input = CharStreams.fromFileName("test\\test.txt");
        JavaMiniLexer lexer = new JavaMiniLexer(input);
        JavaMiniParser parser = new JavaMiniParser(new CommonTokenStream(lexer));

        Program prgm = ProgramAdapter.adapt(parser.compilationUnit());
        System.out.println("Abstract syntax was generated!");

        // If you want to have a StringTree output in the console please comment the 2 above lines when constructing object prgm, because this makes the parser object unusable.
        //System.out.print("parser output: ");
        //System.out.println(parser.compilationUnit().toStringTree(parser));



    }



}
