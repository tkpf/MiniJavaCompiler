package typecheck;

import syntaxtree.Type;
import typecheck.exceptions.AlreadyDefinedException;
import typecheck.exceptions.MissingSymbolException;

import java.util.HashMap;

public class Scope {
    public final Type thisClass;
    private final HashMap<String, Type> fields;
    private final HashMap<Signature, Type> methods;

    public Scope(Type thisClass) {
        this.thisClass = thisClass;
        this.fields = new HashMap<>();
        this.methods = new HashMap<>();
    }

    public void addField(String name, Type type) throws AlreadyDefinedException {
        if (fields.containsKey(name)) {
            throw new AlreadyDefinedException(name);
        } else {
            fields.put(name, type);
        }
    }

    public Type lookupField(String name) throws MissingSymbolException {
        Type result = fields.get(name);
        if (result == null) {
            throw new MissingSymbolException(name);
        } else {
            return result;
        }
    }

    public void addMethod(Signature sig, Type type) throws AlreadyDefinedException {
        if (methods.containsKey(sig)) {
            throw new AlreadyDefinedException(sig.toString());
        } else {
            methods.put(sig, type);
        }
    }

    public Type lookupMethod(Signature sig) throws MissingSymbolException {
        Type result = methods.get(sig);
        if (result == null) {
            throw new MissingSymbolException(sig.toString());
        } else {
            return result;
        }
    }

    @Override
    public String toString() {
        return fields.toString() + " " + methods.toString();
    }
}
