package codegen;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import parser.adapter.ProgramAdapter;
import parser.exceptions.EscapeHatchException;
import parser.production.JavaMiniLexer;
import parser.production.JavaMiniParser;
import syntaxtree.Class;
import syntaxtree.Program;
import typecheck.TypeCheck;
import typecheck.exceptions.AlreadyDefinedException;
import typecheck.exceptions.MissingSymbolException;
import typecheck.exceptions.TypeMismatchException;

import java.io.IOException;
import java.util.Vector;

import static codegen.ClassGenerator.cw2file;
import static codegen.ClassGenerator.generateClassCode;

public class ProgramGenerator {
    public static void generateProgram(Program program, String outputPath) throws IOException {
        for (Class c : program.classes) {
            cw2file(generateClassCode(c), outputPath);
        }
    }

    public static void compile(String filepath, String outputPath, boolean print) throws IOException, EscapeHatchException, MissingSymbolException, AlreadyDefinedException, TypeMismatchException {
        CharStream input = CharStreams.fromFileName(filepath);
        JavaMiniLexer lexer = new JavaMiniLexer(input);
        JavaMiniParser parser = new JavaMiniParser(new CommonTokenStream(lexer));
        Program prgm = ProgramAdapter.adapt(parser.compilationUnit());
        TypeCheck typeCheck = new TypeCheck(prgm);
        typeCheck.check();

        if(print) { System.out.println(prgm); }

        generateProgram(prgm, outputPath);
    }

    public static void compile(String inputPath, String outputPath) throws EscapeHatchException, MissingSymbolException, AlreadyDefinedException, TypeMismatchException, IOException {
        compile(inputPath, outputPath,false);
    }

    public static void main(String[] args) throws IOException, EscapeHatchException, MissingSymbolException, AlreadyDefinedException, TypeMismatchException {
        compile("./src/codegen/testing/ExamplesToTest.txt", "./out");
    }
}
