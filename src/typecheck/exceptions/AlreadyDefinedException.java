package typecheck.exceptions;

public class AlreadyDefinedException extends Exception {

    public AlreadyDefinedException() {
        super();
    }
    public AlreadyDefinedException(String message) {
        super(message);
    }
    
}
