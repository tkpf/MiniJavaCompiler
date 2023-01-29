package typecheck;

import syntaxtree.Type;
import typecheck.exceptions.AlreadyDefinedException;
import typecheck.exceptions.MissingSymbolException;

import java.util.HashMap;

public class LocalScope {
    public final Type thisClass;
    private HashMap<String, Type> fields;
    private HashMap<String, Type> methods;

    LocalScope(Type thisClass) {
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
}
