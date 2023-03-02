package typecheck;

import syntaxtree.Program;
import syntaxtree.Class;
import syntaxtree.Field;
import syntaxtree.Method;
import syntaxtree.Type;
import typecheck.exceptions.AlreadyDefinedException;
import typecheck.exceptions.MissingSymbolException;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class GlobalScope {
    public static Set<Type> primitives = Set.of(
            new Type("int"),
            new Type("boolean"),
            new Type("char"),
            new Type("String")
    );
    HashMap<Type, Scope> classes;

    public GlobalScope(Program prgm)
            throws AlreadyDefinedException, MissingSymbolException {
        classes = new HashMap<>();
        // add classes
        for (Class c : prgm.classes) {
            if (classes.put(c.name, new Scope(c.name)) != null) {
                throw new AlreadyDefinedException(c.name.toString());
            }
        }

        // add fields and methods to class scopes
        for (Class cls : prgm.classes) {
            Scope thisClassScope = classes.get(cls.name);

            for (Field field : cls.fields) {
                // if field is NOT of primitive type
                if (!primitives.contains(field.type)) {
                    // check if type is part of `classes`
                    if (!classes.containsKey(field.type)) {
                        throw new MissingSymbolException(field.type.toString());
                    }
                }
                     // try to add field to class scope
                if (!thisClassScope.addField(field.name, field.type)) {
                    throw new AlreadyDefinedException(cls.name.toString(), field.name);
                }
            }

            for (Method method : cls.meths) {
                // get method signature
                Signature methodSignature = Signature.of(method);
                     // try to add method to class scope
                if (!thisClassScope.addMethod(methodSignature, method.type)) {
                    throw new AlreadyDefinedException(cls.name.toString(), methodSignature.name);
                }
            }
            // add default constructor
            Signature defCons = new Signature(cls.name.toString(), List.of());
            thisClassScope.addMethod(defCons, cls.name);
        }
    }

    private Scope getClassScope(Type className) throws MissingSymbolException {
        Scope result = classes.get(className);
        if (result == null) {
            throw new MissingSymbolException(className.name);
        } else {
            return result;
        }
    }

    public Type lookupField(Type className, String fieldName)
            throws MissingSymbolException {
        Scope thisClassScope = getClassScope(className);
        Optional<Type> result = thisClassScope.lookupField(fieldName);
        if (result.isPresent()) {
            return result.get();
        } else {
            throw new MissingSymbolException(fieldName);
        }
    }

    public Type lookupMethod(Type className, Signature methodSignature)
            throws MissingSymbolException {
        Scope thisClassScope = getClassScope(className);
        Optional<Type> result = thisClassScope.lookupMethod(methodSignature);
        if (result.isPresent()) {
            return result.get();
        } else {
            throw new MissingSymbolException(methodSignature.toString());
        }
    }

    @Override
    public String toString() {
        String result = "GlobalScope:\n";
        for (Type cls : classes.keySet()) {
            result += "Class " + cls.name + ": " + classes.get(cls).toString() + "\n";
        }
        if (classes.keySet().size() > 0) result = result.substring(0, result.length() -1);
        return result;
    }
}
