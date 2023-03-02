package syntaxtree;

import java.util.Vector;

public class Program {
    public final Vector<Class> classes;

    public Program(Vector<Class> classes) {
        this.classes = classes;
    }

    @Override
    public String toString() {
        String result = "(Program [";
        for (Class c : classes) {
            result += c.toString() + " ";
        }
        if (classes.size() > 0) result = result.substring(0, result.length() - 1);
        result += "])";

        return result;
    }
}
