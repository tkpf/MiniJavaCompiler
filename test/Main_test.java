import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import parser.adapter.ClassAdapter;
import parser.production.JavaMiniLexer;
import parser.production.JavaMiniParser;
import syntaxtree.Class;

import java.io.IOException;

public class Main_test {

    public static void main(String[] args) throws IOException  {

        System.out.println("Running Main_test");
        CharStream input = CharStreams.fromFileName("C:\\Users\\Till\\prjcts\\Mini-Java-Compiler\\test\\test.txt");
        JavaMiniLexer lexer = new JavaMiniLexer(input);
        JavaMiniParser parser = new JavaMiniParser(new CommonTokenStream(lexer));

        Class c = ClassAdapter.adapt(parser.compilationUnit().typeDeclaration(0).classDeclaration());
        System.out.println(c);

    }



}
