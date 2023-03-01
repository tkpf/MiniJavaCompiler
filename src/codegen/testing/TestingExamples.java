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

import static codegen.ProgramGenerator.compile;
import static codegen.ProgramGenerator.generateProgram;

public class TestingExamples {


    public static void main(String[] args) throws IOException, MissingSymbolException, AlreadyDefinedException, TypeMismatchException, EscapeHatchException {
        compile("./src/codegen/testing/ExamplesToTest.txt", "./out", true);
        compile("./test/test_basicClasses.txt", "./out/compiler output", true);
        compile("./test/test_ProgrammAboutShapes.txt", "./out/compiler output", true);
    }
}
