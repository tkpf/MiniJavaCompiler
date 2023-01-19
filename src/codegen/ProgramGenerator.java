package codegen;

import syntaxtree.Class;

import java.io.IOException;
import java.util.Vector;

import static codegen.ClassGenerator.cw2file;
import static codegen.ClassGenerator.generateClassCode;

public class ProgramGenerator {
    public static void generateProgram(Vector<Class> classes) throws IOException {
        for (Class c : classes) {
            cw2file(generateClassCode(c));
        }
    }
}
