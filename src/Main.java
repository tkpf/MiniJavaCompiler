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
    public static void main(String[] args)
            throws EscapeHatchException, IOException,
            MissingSymbolException, AlreadyDefinedException,
            TypeMismatchException, InterruptedException {
        if (args.length != 2) {
            System.out.println("Help text.");
            return;
        }
        String outputPath = "./out";

        ProgramGenerator.compile(args[0], outputPath, true);
        javaCompileMain(args[1], outputPath);
        javaRunMain(args[1], outputPath);
    }

    private static void javaRunMain(String main, String outputPath)
            throws IOException, InterruptedException {
        String command = "java -cp " + outputPath + " " + main.replace(".java", "");
        runProcess(command);
    }
    private static void javaCompileMain(String main, String outputPath)
            throws IOException, InterruptedException {
    String command = "javac -cp " + outputPath + " -d " + outputPath + " " + main;
        runProcess(command);
    }

    private static void printLines(String cmd, InputStream ins) throws IOException {
        String line = null;
        BufferedReader in = new BufferedReader(
                new InputStreamReader(ins));
        while ((line = in.readLine()) != null) {
            System.out.println(cmd + " " + line);
        }
    }
    private static void runProcess(String command)
            throws IOException, InterruptedException {
        Process pro = Runtime.getRuntime().exec(command);
        printLines(command + " stdout:", pro.getInputStream());
        printLines(command + " stderr:", pro.getErrorStream());
        pro.waitFor();
        System.out.println(command + " exitValue() " + pro.exitValue());
    }
}
