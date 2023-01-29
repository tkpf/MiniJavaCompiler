package syntaxtree.expressions;

public final class LocalOrFieldVarExpr extends Expression {

    public enum VarType {
        unknown, local, field
    }

    public final String name;
    public VarType context;

    public LocalOrFieldVarExpr (String name) {
        this.name = name;
        this.context = VarType.unknown;
    }

    @Override
    public String toString() {
        String result = "(";
        switch (context) {
            case unknown -> result += "LoFVar";
            case local   -> result += "LocalVar";
            case field   -> result += "FieldVar";
        }
        result  += super.toString() + name + ")";
        return result;
    }
}
