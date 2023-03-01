package tests_final;

import parser.exceptions.EscapeHatchException;
import typecheck.exceptions.AlreadyDefinedException;
import typecheck.exceptions.MissingSymbolException;
import typecheck.exceptions.TypeMismatchException;

import java.io.IOException;

import static codegen.ProgramGenerator.compile;

public class TestsMain {
    public static void main(String[] args) throws EscapeHatchException, MissingSymbolException, AlreadyDefinedException, TypeMismatchException, IOException {
        compile("./test/tests_final/Tests.txt", "./test/tests_final/out");
    }
}
