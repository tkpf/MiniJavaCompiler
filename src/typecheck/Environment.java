package typecheck;

import syntaxtree.Class;
import syntaxtree.Method;
import syntaxtree.Field;
import syntaxtree.Program;
import syntaxtree.Type;
import typecheck.exceptions.AlreadyDefinedException;
import typecheck.exceptions.MissingSymbolException;

import java.util.HashMap;
import java.util.Set;

public class Environment {
    public static Set<Type> primitives = Set.of(
            new Type("int"),
            new Type("bool"),
            new Type("char"),
            new Type("String"),
            new Type("void")
    );

    public HashMap<String, HashMap<String, Type>> fields;
    public HashMap<String, HashMap<String, Type>> methods;

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
                    if (fields.containsKey(f.type)) {
                        fieldsMap.put(f.name, f.type);
                    } else {
                        throw new MissingSymbolException();
                    }
                }
            }
            HashMap<String, Type> methodsMap = methods.get(c.name.toString());
            for (Method m : c.meths) {
                if (primitives.contains(m.type)) {
                    if (methodsMap.put(m.name, m.type) != null) {
                        throw new AlreadyDefinedException();
                    }
                } else {
                    if (methods.containsKey(m.type)) {
                        methodsMap.put(m.name, m.type);
                    } else {
                        throw new MissingSymbolException();
                    }
                }
            }
        }
    }



}
