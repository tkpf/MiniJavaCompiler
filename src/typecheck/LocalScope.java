package typecheck;

import syntaxtree.Type;
import typecheck.exceptions.AlreadyDefinedException;
import typecheck.exceptions.MissingSymbolException;

import java.util.ArrayList;
import java.util.Optional;

public class LocalScope {
    private final ArrayList<Scope> layers;
    private int currentScope;

    public LocalScope(Type className) {
        layers = new ArrayList<>();
        currentScope = 0;
        layers.add(0, new Scope(className));
    }

    public void addField(String name, Type type) throws AlreadyDefinedException {
        if(!layers.get(currentScope).addField(name, type)) {
            throw new AlreadyDefinedException(name);
        }
    }

    public Type lookupField(String name) throws MissingSymbolException {
        for (int i = currentScope; i >= 0; i--) {
            Optional<Type> result = layers.get(i).lookupField(name);
            if (result.isPresent()) {
                return result.get();
            }
        }
        throw new MissingSymbolException(name);
    }

    public Type getCurrentClass() {
        return layers.get(currentScope).thisClass;
    }

    public void newBlock() {
        Type thisClass = getCurrentClass();
        currentScope += 1;
        layers.add(currentScope, new Scope(thisClass));
    }

    public void closeBlock() {
        currentScope -= 1;
    }
}
