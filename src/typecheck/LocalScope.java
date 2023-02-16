package typecheck;

import syntaxtree.Type;
import typecheck.exceptions.AlreadyDefinedException;
import typecheck.exceptions.MissingSymbolException;

import java.util.ArrayList;
import java.util.HashMap;

public class LocalScope {
    private ArrayList<Scope> layers;
    private int currentScope;

    public LocalScope(Type className) {
        layers = new ArrayList<>();
        currentScope = 0;
        layers.add(0, new Scope(className));
    }

    public void addField(String name, Type type) throws AlreadyDefinedException {
        layers.get(currentScope).addField(name, type);
    }

    public Type lookupField(String name) throws MissingSymbolException {
        // TODO: Implement nested blocks
        return layers.get(currentScope).lookupField(name);
    }

    public Type getCurrentClass() {
        return layers.get(currentScope).thisClass;
    }
}
