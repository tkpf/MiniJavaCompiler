package typecheck;

import syntaxtree.Type;
import typecheck.exceptions.AlreadyDefinedException;
import typecheck.exceptions.MissingSymbolException;

import java.util.HashMap;
import java.util.Optional;

public class Scope {
    public final Type thisClass;
    private final HashMap<String, Type> fields;
    private final HashMap<Signature, Type> methods;

    public Scope(Type thisClass) {
        this.thisClass = thisClass;
        this.fields = new HashMap<>();
        this.methods = new HashMap<>();
    }

    public boolean addField(String name, Type type) {
        if (fields.containsKey(name)) {
            return false;
        } else {
            fields.put(name, type);
            return true;
        }
    }

    public Optional<Type> lookupField(String name) {
        if (fields.containsKey(name)) {
            return Optional.of(fields.get(name));
        } else {
            return Optional.empty();
        }
    }

    public boolean addMethod(Signature sig, Type type) {
        if (methods.containsKey(sig)) {
            return false;
        } else {
            methods.put(sig, type);
            return true;
        }
    }

    public Optional<Type> lookupMethod(Signature sig) {
        if (methods.containsKey(sig)) {
            return Optional.of(methods.get(sig));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public String toString() {
        return fields.toString() + " " + methods.toString();
    }
}
