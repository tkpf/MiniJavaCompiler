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

import java.io.*;

public class MiniJavaCompiler {
    static boolean printAST = false;
    static boolean printUntyped = false;
    static boolean printGlobalScope = false;
    static boolean runJava = false;
    static boolean verbose = false;
    static String outputPath = "./out";
    static String mainFile = "";
    static String sourceFile = "";

    public static void main(String[] args)
            throws EscapeHatchException, IOException, InterruptedException,
                   MissingSymbolException, AlreadyDefinedException, TypeMismatchException
    {
        if (args.length < 1) {
            helpText();
            System.exit(1);
        }
        parseArgs(args);

        File outDir = new File(outputPath);
        if (!outDir.exists()) {
            if (verbose) {
                System.out.println("Output directory " + outputPath + " doesn't exist." +
                                   "Creating directory.");
            }
            outDir.mkdir();
        }

        miniJavaCompile(sourceFile);
        if (!(mainFile.equals(""))) javaCompileMain(mainFile);
        if (runJava && !mainFile.equals("")) javaRunMain(mainFile);
    }

    private static void parseArgs(String[] args) {
        for (int i = 0; i < args.length - 1; i++) {
            String currentArg = args[i];
            if (currentArg.equals("-o")) {
                outputPath = args[++i];
            } else if (currentArg.startsWith("-")) {
                for (char c : currentArg.toCharArray()) {
                    switch (c) {
                        case 'a' -> printAST = true;
                        case 'g' -> printGlobalScope = true;
                        case 'h' -> { helpText(); System.exit(0); }
                        case 'r' -> runJava = true;
                        case 'u' -> printUntyped = true;
                        case 'v' -> verbose = true;
                        default -> { } // ignore
                    }
                }
            } else if (currentArg.endsWith(".java")) {
                mainFile = currentArg;
            } else {
                helpText();
                System.exit(1);
            }
        }
        // last argument must be source file
        sourceFile = args[args.length-1];
    }

    private static void miniJavaCompile(String sourceFile)
            throws IOException, EscapeHatchException,
                   MissingSymbolException, AlreadyDefinedException, TypeMismatchException
    {
        CharStream input = CharStreams.fromFileName(sourceFile);

        if (verbose) System.out.println("Parsing file " + sourceFile + ".");
        JavaMiniLexer lexer = new JavaMiniLexer(input);
        JavaMiniParser parser = new JavaMiniParser(new CommonTokenStream(lexer));

        // generate yet-untyped AST
        if (verbose) System.out.println("Generating untyped abstract syntax tree.");
        Program prgm = ProgramAdapter.adapt(parser.compilationUnit());
        if (printUntyped) System.out.println(prgm);

        if (verbose) System.out.println("Typing abstract syntax tree.");
        TypeCheck typeCheck = new TypeCheck(prgm);
        if (printGlobalScope) System.out.println(typeCheck.getGlobalScope());
        typeCheck.check();
        if (printAST) System.out.println(prgm);

        if (verbose) System.out.println("Compiling abstract syntax tree into class files.");
        ProgramGenerator.generateProgram(prgm, outputPath);
    }

    private static void javaCompileMain(String main)
            throws IOException, InterruptedException {
        String[] command = {"javac", "-cp", outputPath, "-d", outputPath, main};
        int exit = runProcess(command);
    }
    private static void javaRunMain(String main)
            throws IOException, InterruptedException {
        String[] command = {"java", "-cp", outputPath, main.replace(".java", "")};
        int exit = runProcess(command);
    }

    private static int runProcess(String[] command) throws IOException, InterruptedException {
        Process process = Runtime.getRuntime().exec(command);
        if (verbose) System.out.println("Running process invoked by \"" + String.join(" ", command) + "\"");
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
                    java Main [-aghruv] [-o output_dir] [main_file.java] minijava_target_file
                DESCRIPTION:
                    Compiles <minijava_target_file> with the MiniJavaCompiler, creating
                    compiled class-files in the "./out/" directory by default.
                    Optionally compiles an accompanying <main_file>.java with the system-
                    installed `javac` compiler.
                OPTIONS:
                    -a : Prints string representation of typed AST.
                    -u : Prints string representation of yet-untyped AST before the
                         typechecker is invoked.
                    -g : Prints contents of global scope of program.
                    -h : Print this help message.
                    -r : Runs supplied main-file directly after compilation. Ignored if
                         there is none.
                    -v : Run verbosely.
                    -o output_dir : Generated class-files will be saved in <output_dir>.
                                    Path is relative to current working directory.
                                    Default output path is "./out/".
                """);
    }

}
