package syntaxtree;

public final class Type {

    public final String name;

    public Type(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Type)) return false;
        Type t = (Type) obj;
        return this.name.equals(t.name);
    }

    public boolean equals(String s) {
        return this.name.equals(s);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
