import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import parser.adapter.ProgramAdapter;
import parser.production.JavaMiniLexer;
import parser.production.JavaMiniParser;
import syntaxtree.Program;
import typecheck.Environment;
import typecheck.TypeCheck;
import typecheck.exceptions.AlreadyDefinedException;
import typecheck.exceptions.MissingSymbolException;
import typecheck.exceptions.TypeMismatchException;

import java.io.IOException;

public class Main_test {

    public static void main(String[] args)
            throws IOException, MissingSymbolException, AlreadyDefinedException, TypeMismatchException {

        System.out.println("Running Main_test");
        CharStream input = CharStreams.fromFileName("./test/test.txt");
        JavaMiniLexer lexer = new JavaMiniLexer(input);
        JavaMiniParser parser = new JavaMiniParser(new CommonTokenStream(lexer));

        System.out.print("parser output: ");
        //System.out.println(parser.compilationUnit().toStringTree(parser));

        Program prgm = ProgramAdapter.adapt(parser.compilationUnit());
        System.out.println(prgm);

        TypeCheck typeCheck = new TypeCheck(prgm);
        System.out.println(typeCheck.env.fields + "\n" + typeCheck.env.methods);
        typeCheck.check();
        System.out.print(prgm);
    }



}
