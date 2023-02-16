package typecheck;

import java.util.HashMap;

public class GlobalScope {

    HashMap<String, Scope> classes;

    public GlobalScope() {
        classes = new HashMap<>();
    }
}
