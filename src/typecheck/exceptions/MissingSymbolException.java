package typecheck.exceptions;

public class MissingSymbolException extends Exception {

    public MissingSymbolException() {
        super();
    }
    public MissingSymbolException(String message) {
        super(message);
    }

}
