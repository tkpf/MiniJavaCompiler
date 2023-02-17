package typecheck;

import syntaxtree.Class;
import syntaxtree.Method;
import syntaxtree.Field;
import syntaxtree.Program;
import syntaxtree.Type;
import syntaxtree.Parameter;
import typecheck.exceptions.AlreadyDefinedException;
import typecheck.exceptions.MissingSymbolException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Environment {
    public static Set<Type> primitives = Set.of(
            new Type("int"),
            new Type("boolean"),
            new Type("char"),
            new Type("String"),
            new Type("void")
    );

    public HashMap<String, HashMap<String, Type>> fields;
    public HashMap<String, HashMap<Signature, Type>> methods;

    public Environment(Program prgm)
            throws AlreadyDefinedException, MissingSymbolException {
        fields = new HashMap<>();
        methods = new HashMap<>();
        for (Class c : prgm.classes) {
            fields.put(c.name.toString(), new HashMap<>(c.fields.size()));
            methods.put(c.name.toString(), new HashMap<>(c.meths.size()));
        }
        for (Class c : prgm.classes) {
            HashMap<String, Type> fieldsMap = fields.get(c.name.toString());
            for (Field f : c.fields) {
                if (primitives.contains(f.type)) {
                    if (fieldsMap.put(f.name, f.type) != null) {
                        throw new AlreadyDefinedException();
                    }
                } else {
                    if (fields.containsKey(f.type.toString())) {
                        fieldsMap.put(f.name, f.type);
                    } else {
                        throw new MissingSymbolException();
                    }
                }
            }
            HashMap<Signature, Type> methodsMap = methods.get(c.name.toString());
            for (Method m : c.meths) {
                // create signature of method
                ArrayList<Type> paramTypes = new ArrayList<>(m.params.size());
                for (Parameter p : m.params) {
                    paramTypes.add(p.type);
                }
                Signature methodSignature = new Signature(m.name, paramTypes);

                if (methodsMap.containsKey(methodSignature)) {
                    throw new AlreadyDefinedException(m.name);
                }
                methodsMap.put(methodSignature, m.type);
            }
            // add default constructor
            Signature defCons = new Signature(c.name.toString(), List.of());
            methodsMap.put(defCons, c.name);
        }
        System.out.println(fields + "\n" + methods);
    }

    public Type lookupClass(String name) throws MissingSymbolException {
        if (fields.containsKey(name)) {
            return new Type(name);
        } else {
            throw new MissingSymbolException();
        }
    }

    public Type lookupField(Type className, String fieldName) throws MissingSymbolException {
        HashMap<String, Type> classFields = fields.get(className.toString());
        if (classFields != null) {
            Type result = classFields.get(fieldName);
            if (result != null) {
                return result;
            } else {
                throw new MissingSymbolException(fieldName);
            }
        } else {
            throw new MissingSymbolException(className.toString());
        }
    }

    public Type lookupMethod(Type className, Signature methodSignature)
            throws MissingSymbolException {
        HashMap<Signature, Type> classMethods = methods.get(className.toString());
        if (classMethods != null) {
            Type result = classMethods.get(methodSignature);
            if (result != null) {
                return result;
            } else {
                throw new MissingSymbolException(methodSignature.toString());
            }
        } else {
            throw new MissingSymbolException(className.toString());
        }
    }


}
