package syntaxtree;

public class Field {
    final private String name;
    final private TypeExpr type;

    public Field (String name, String type) {
        this.name = name;
        this.type = new TypeExpr(type);
    }
}
