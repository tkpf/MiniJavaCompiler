package codegen.testing;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import parser.adapter.ProgramAdapter;
import parser.exceptions.EscapeHatchException;
import parser.production.JavaMiniLexer;
import parser.production.JavaMiniParser;
import syntaxtree.Program;
import typecheck.TypeCheck;
import typecheck.exceptions.*;

import java.io.IOException;

import static codegen.ProgramGenerator.generateProgram;

public class TestingExamples {


    public static void main(String[] args) throws IOException, MissingSymbolException, AlreadyDefinedException, TypeMismatchException, EscapeHatchException {
        /*
        TestClass t = new TestClass();

        t.storeThings(1, 'Q', false, "foo");
        t.createEmpty();
        System.out.println(t.addStrings("asldkfj","1234"));
        System.out.println(t.choose(8, 9, false));
        System.out.println(t.sumUp(5));
        System.out.println(t.sumUpRecursive(5));
        System.out.println(t.testStore());
        */

        CharStream input = CharStreams.fromFileName("./src/codegen/testing/ExamplesToTest.txt");
        JavaMiniLexer lexer = new JavaMiniLexer(input);
        JavaMiniParser parser = new JavaMiniParser(new CommonTokenStream(lexer));
        Program prgm = ProgramAdapter.adapt(parser.compilationUnit());
        TypeCheck typeCheck = new TypeCheck(prgm);
        typeCheck.check();
        System.out.print(prgm);

        generateProgram(prgm);
    }
}
