package codegen;

import org.objectweb.asm.*;
import org.objectweb.asm.Type;
import syntaxtree.*;
import syntaxtree.Class;
import syntaxtree.expressions.Expression;
import syntaxtree.expressions.JNullExpr;
import syntaxtree.statementexpressions.MethodCallStmtExpr;
import syntaxtree.expressions.LocalOrFieldVarExpr;
import syntaxtree.expressions.StmtExprExpr;
import syntaxtree.statementexpressions.AssignStmtExpr;
import syntaxtree.statementexpressions.StatementExpression;
import syntaxtree.statements.BlockStmt;
import syntaxtree.statements.ReturnStmt;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Objects;
import java.util.Vector;
import java.util.function.BinaryOperator;

import static codegen.ExpressionGenerator.genExpr;
import static codegen.StatementExpressionGenerator.genAssign;
import static codegen.StatementGenerator.*;

public class ClassGenerator {
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
            cw.visitField(
                    Opcodes.ACC_PUBLIC,
                    f.name,
                    fieldDescriptor(f.type.name),
                    null,
                    "value").visitEnd();
        }

        if(inputClass.meths.stream().noneMatch(m -> Objects.equals(m.name, inputClass.name.name)))
        {
            inputClass.meths.add(
                    new Method(
                            inputClass.name.name,
                            inputClass.name,
                            new Vector<>(),
                            new BlockStmt(new Vector<>())
                            )
            );
        }

            // generating methods
        for(Method m : inputClass.meths)
        {
            if (Objects.equals(m.name, inputClass.name.name))
            {
               m.visitor = cw.visitMethod(
                        Opcodes.ACC_PUBLIC,
                        "<init>",
                        constructorDescriptor(m),
                        null,
                        null);
               m.visitor.visitEnd();
               m.ownerClass = inputClass;
               generateConstructor(m);
            }
            else
            {
                m.visitor = cw.visitMethod(
                        Opcodes.ACC_PUBLIC,
                        m.name,
                        methodDescriptor(m),
                        null,
                        null);
                m.visitor.visitEnd();
                m.ownerClass = inputClass;
                generateMethodCode(m);
            }
        }

        // generate default constructor if no constructor is explicitly stated

        /*if(inputClass.meths.stream().noneMatch(m -> Objects.equals(m.name, inputClass.name.name))) {
            MethodVisitor constructor = cw.visitMethod(
                    Opcodes.ACC_PUBLIC,
                    "<init>",
                    "()V",
                    null,
                    null);
            constructor.visitCode();
            constructor.visitVarInsn(Opcodes.ALOAD, 0);
            constructor.visitMethodInsn(Opcodes.INVOKESPECIAL,"java/lang/Object", "<init>", "()V", false);
            constructor.visitInsn(Opcodes.RETURN);
            constructor.visitMaxs(0, 0);
            constructor.visitEnd();
        }*/


        cw.visitEnd();

        return cw;
    }

    public static void generateMethodCode(Method m)   // this only works for non-static methods
    {
        m.visitor.visitCode();

        //m.visitor.visitVarInsn(Opcodes.ALOAD, 0);
        generateParameters(m);

        genStmt(m.blck, m);

        // adding 'return;' at the end of void-blocks in case they are not explicit in the code (since java allows to omit them)
        if (m.blck.stmtBlck.isEmpty() ||
                (Objects.equals(m.blck.type.name, "void") && m.blck.stmtBlck.lastElement().getClass() != ReturnStmt.class))
        {
            m.visitor.visitInsn(Opcodes.RETURN);
        }

        m.visitor.visitMaxs(0,0);
        m.visitor.visitEnd();
    }

    public static void generateConstructor(Method m)
    {
        m.visitor.visitCode();

        m.visitor.visitVarInsn(Opcodes.ALOAD, 0);
        m.visitor.visitMethodInsn(Opcodes.INVOKESPECIAL,"java/lang/Object", "<init>", "()V", false);
        generateFieldAssignments(m);
        generateParameters(m);
        genStmt(m.blck, m);

        // adding 'return;' at the end of void-blocks in case they are not explicit in the code (since java allows to omit them)
        if (m.blck.stmtBlck.isEmpty() ||
                (Objects.equals(m.blck.type.name, "void") && m.blck.stmtBlck.lastElement().getClass() != ReturnStmt.class))
        {
            m.visitor.visitInsn(Opcodes.RETURN);
        }

        m.visitor.visitMaxs(0, 0);
        m.visitor.visitEnd();
    }

    private static void generateFieldAssignments(Method m)
    {
        for (Field f : m.ownerClass.fields)
        {
            if (f.assignment instanceof AssignStmtExpr s) {
                genAssign(s, m);
            } else if (f.assignment != null){
                throw new IllegalStateException("Unexpected value: " + f.assignment);
            }
        }
    }



    private static void generateParameters(Method m) {
        int count = 1;  //'this' is at index 0
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
            case "void" -> Type.VOID_TYPE.getDescriptor();
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
        return "("+paramDesc+")"+fieldDescriptor(m.type.name);
    }

    static String methodDescriptor(MethodCallStmtExpr mcall)
    {
        String paramDesc = "";
        for (Expression expr : mcall.methParams)
        {
            paramDesc += fieldDescriptor(expr.type.name);
        }
        return "("+paramDesc+")"+fieldDescriptor(mcall.innerType.name);
    }

    static String constructorDescriptor(Method m){
        String paramDesc = "";
        for (Parameter p : m.params)
        {
            paramDesc += fieldDescriptor(p.type.name);
        }
        return "("+paramDesc+")V";
    }

    static void cw2file(ClassWriter cw, String outputDirectory) throws IOException {
        byte[] bytes = cw.toByteArray();
        String className = new ClassReader(bytes).getClassName();
        File outputFile = new File(outputDirectory, className + ".class");
        FileOutputStream output = new FileOutputStream(outputFile);
        output.write(bytes);
        output.close();
    }


}
