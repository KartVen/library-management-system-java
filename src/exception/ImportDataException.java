package exception;

public class ImportDataException extends RuntimeException {
    public ImportDataException(String message) {
        super("ImportDataException: " + message);
    }
}