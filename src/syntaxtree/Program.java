package syntaxtree;

import java.util.Vector;

public class Program {
    private final Vector<Class> classes;

    public Program(Vector<Class> classes) {
        this.classes = classes;
    }

    @Override
    public String toString() {
        String result = "(Program [";
        for (Class c : this.classes) {
            result += c.toString() + " ";
        }
        result += "])";

        return result;
    }
}
