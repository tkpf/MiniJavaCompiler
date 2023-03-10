package syntaxtree;

public class Parameter {

    final public String name;
    final public Type type;

    public Parameter(String name, Type type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return "(Parameter:" + this.type + " " + this.name + ")";
    }
}
