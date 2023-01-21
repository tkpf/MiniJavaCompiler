package codegen;

import syntaxtree.Class;
import syntaxtree.Examples;
import syntaxtree.Program;

import java.io.IOException;
import java.util.Vector;

import static codegen.ClassGenerator.cw2file;
import static codegen.ClassGenerator.generateClassCode;

public class ProgramGenerator {
    public static void generateProgram(Program program) throws IOException {
        for (Class c : program.classes) {
            cw2file(generateClassCode(c));
        }
    }

    public static void main(String[] args) throws IOException {
        generateProgram(Examples.program1);
    }
}
