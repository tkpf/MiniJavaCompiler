package typecheck;

import syntaxtree.Method;
import syntaxtree.Parameter;
import syntaxtree.Type;

import java.util.ArrayList;
import java.util.List;

public class Signature {
    String name;
    List<Type> args;

    public Signature(String name, List<Type> args) {
        this.name = name;
        this.args = args;
    }

    public static Signature of(Method method) {
        ArrayList<Type> paramTypes = new ArrayList<>(method.params.size());
        for (Parameter p : method.params) {
            paramTypes.add(p.type);
        }
        return new Signature(method.name, paramTypes);
    }

    @Override
    public String toString() {
        String result = name + "(";
        for (Type t : args) {
            result += t + ", ";
        }
        if (args.size() > 0) {
            result = result.substring(0, result.length() - 2);
        }
        return result + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Signature)) return false;
        Signature other = (Signature) obj;
        boolean result = true;
        result &= this.name.equals(other.name);
        if (this.args.size() == other.args.size()) {
            for (int i = 0; i < this.args.size(); i++) {
                result &= this.args.get(i).equals(other.args.get(i));
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
