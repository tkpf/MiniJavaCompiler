import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import parser.adapter.ProgramAdapter;
import parser.production.JavaMiniLexer;
import parser.production.JavaMiniParser;
import syntaxtree.Program;
import typecheck.TypeCheck;
import codegen.ProgramGenerator;
import parser.exceptions.EscapeHatchException;
import typecheck.exceptions.AlreadyDefinedException;
import typecheck.exceptions.MissingSymbolException;
import typecheck.exceptions.TypeMismatchException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main {
    static boolean printAST = false;
    static boolean printGlobalScope = false;
    static boolean runJava = true;
    static String outputPath = "./out";

    public static void main(String[] args)
            throws EscapeHatchException, IOException, InterruptedException,
                   MissingSymbolException, AlreadyDefinedException, TypeMismatchException
    {
        if (args.length < 1 || args.length > 2) {
            helpText();
            System.exit(1);
        }

        miniJavaCompile(args[0]);
        if (args.length > 1) javaCompileMain(args[1]);
        if (runJava) javaRunMain(args[1]);
    }

    private static void miniJavaCompile(String sourceFile)
            throws IOException, EscapeHatchException,
                   MissingSymbolException, AlreadyDefinedException, TypeMismatchException
    {
        CharStream input = CharStreams.fromFileName(sourceFile);

        JavaMiniLexer lexer = new JavaMiniLexer(input);
        JavaMiniParser parser = new JavaMiniParser(new CommonTokenStream(lexer));

        // generate yet-untyped AST
        Program prgm = ProgramAdapter.adapt(parser.compilationUnit());

        TypeCheck typeCheck = new TypeCheck(prgm);
        typeCheck.check();
        if(printAST) { System.out.println(prgm); }

        ProgramGenerator.generateProgram(prgm, outputPath);
    }

    private static void javaCompileMain(String main)
            throws IOException, InterruptedException {
        String command = "javac -cp " + outputPath + " -d " + outputPath + " " + main;
        int exit = runProcess(command);
    }
    private static void javaRunMain(String main)
            throws IOException, InterruptedException {
        String command = "java -cp " + outputPath + " " + main.replace(".java", "");
        int exit = runProcess(command);
    }

    private static int runProcess(String command) throws IOException, InterruptedException {
        Process process = Runtime.getRuntime().exec(command);
        System.out.println("Running process invoked by \"" + command + "\"");
        streamPrinter("", process.getInputStream());
        streamPrinter("ERR: ", process.getErrorStream());
        process.waitFor();
        return process.exitValue();
    }

    private static void streamPrinter(String prefix, InputStream ins) throws IOException {
        String line = null;
        BufferedReader in = new BufferedReader(new InputStreamReader(ins));
        while ((line = in.readLine()) != null) {
            System.out.println(prefix + line);
        }
    }

    private static void helpText() {
        System.out.println("""
                USAGE:
                    java Main [-agr] [-o output_dir] minijava_target_file [main_file]
                """);
    }

}
