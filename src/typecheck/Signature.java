package typecheck;

import syntaxtree.Type;

import java.util.ArrayList;

public class Signature {
    String name;
    Type[] args;

    public Signature(String name, Type... args) {
        this.name = name;
        this.args = args;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Signature)) return false;
        Signature sig = (Signature) obj;
        boolean result = true;
        result &= this.name.equals(sig.name);
        if (this.args.length == sig.args.length) {
            for (int i = 0; i < this.args.length; i++) {
                result &= this.args[i].equals(sig.args[i]);
            }
        }
        return result;
    }

    @Override
    public int hashCode() {
        String s = name;
        for (Type t : args) {
            s += t;
        }
        return s.hashCode();
    }
}
