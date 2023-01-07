package codegen;

import org.objectweb.asm.*;
import syntaxtree.*;
import syntaxtree.Class;
import syntaxtree.expressions.LocalOrFieldVarExpr;
import syntaxtree.statementexpressions.AssignStmtExpr;
import syntaxtree.statements.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Vector;

public class BytecodeGenerator {


    public static ClassWriter generateClassCode(Class inputClass)
    {
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES | ClassWriter.COMPUTE_MAXS);

        cw.visit(
                Opcodes.V1_8,
                Opcodes.ACC_PUBLIC,
                inputClass.name.name,
                null,
                "java/lang/Object",
                null
        );

        Dictionary<String, FieldVisitor> fieldVisitorDictionary = new Hashtable<>();
        Dictionary<String, MethodVisitor> methodVisitorDictionary = new Hashtable<>();

        for (Field f : inputClass.fields)
        {
            fieldVisitorDictionary.put(
                    f.name,
                    cw.visitField(
                            Opcodes.ACC_PUBLIC,
                            f.name,
                            fieldDescriptor(f.type.name),
                            null,
                            "value"));
            fieldVisitorDictionary.get(f.name).visitEnd();
        }


        for(Method m : inputClass.meths)
        {
            methodVisitorDictionary.put(
                    m.name,
                    cw.visitMethod(
                            Opcodes.ACC_PUBLIC,
                            m.name,
                            methodDescriptor(m),
                            null,
                            null));
            methodVisitorDictionary.get(m.name).visitEnd();
            generateMethodCode(m, methodVisitorDictionary.get(m.name));
        }


        cw.visitEnd();

        return cw;
    }

    public static void generateMethodCode(Method meth, MethodVisitor mv)
    {
        mv.visitCode();

        // TODO generate bytecode instructions

        mv.visitMaxs(0,0);
        mv.visitEnd();
    }

    static String fieldDescriptor(String typeName)
    {
        switch (typeName){
            case "int":
                return Type.INT_TYPE.getDescriptor();
            case "boolean":
                return Type.BOOLEAN_TYPE.getDescriptor();
            case "char":
                return Type.CHAR_TYPE.getDescriptor();
            case "String":
                return Type.getType(String.class).getDescriptor();
        }
        return "L"+typeName+";";
    }

    static String methodDescriptor(Method m)
    {
        String paramDesc = "";
        for (Parameter p : m.params)
        {
            paramDesc += fieldDescriptor(p.type.name);
        }
        return "("+paramDesc+")"+fieldDescriptor(m.rtype.name);
    }

    static void cw2file(ClassWriter cw) throws IOException {
        byte[] bytes = cw.toByteArray();
        String className = new ClassReader(bytes).getClassName();
        File outputFile = new File(".\\out", className + ".class");
        FileOutputStream output = new FileOutputStream(outputFile);
        output.write(bytes);
        output.close();
    }

    public static void main(String[] args) throws IOException {
        cw2file(generateClassCode(Examples.ast5));
    }
}
