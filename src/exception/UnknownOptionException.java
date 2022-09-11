package exception;

public class UnknownOptionException extends RuntimeException {
    public UnknownOptionException(String message) {
        super(message);
    }
}
