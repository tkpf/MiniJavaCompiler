package codegen;

import org.objectweb.asm.*;
import org.objectweb.asm.Type;
import syntaxtree.*;
import syntaxtree.Class;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Dictionary;
import java.util.Hashtable;

import static codegen.StatementGenerator.*;

public class ClassGenerator {

    public static Dictionary<String, FieldVisitor> fieldVisitorDictionary = new Hashtable<>();
    private static Dictionary<String, MethodVisitor> methodVisitorDictionary = new Hashtable<>();

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


        // generating fields
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

        // TODO generate standard constructor

        // generating methods
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
            generateMethodCode(m, inputClass);
        }


        cw.visitEnd();

        return cw;
    }

    public static void generateMethodCode(Method m, Class inputClass)   // this only works for non-static methods
    {
        m.visitor = methodVisitorDictionary.get(m.name);;
        m.visitor.visitCode();

        generateParameters(m);

        genStmt(m.blck, m);

        m.visitor.visitMaxs(0,0);
        m.visitor.visitEnd();
    }


    private static void generateParameters(Method m) {
        //ALOAD 0
        m.visitor.visitVarInsn(Opcodes.ALOAD, 0);

        //other parameters
        int count = 1;
        for (Parameter p : m.params) {
            m.localVariableIndexes.put(p.name, count);
            count++;
        }
    }


    static String fieldDescriptor(String typeName)
    {
        return switch (typeName) {
            case "int" -> Type.INT_TYPE.getDescriptor();
            case "boolean" -> Type.BOOLEAN_TYPE.getDescriptor();
            case "char" -> Type.CHAR_TYPE.getDescriptor();
            case "String" -> Type.getType(String.class).getDescriptor();
            default -> "L" + typeName + ";";
        };
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
        cw2file(generateClassCode(Examples.ast6));
    }
}
