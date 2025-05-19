package nova.exception;

public class IDNotFoundException extends RuntimeException {
    public IDNotFoundException(String message) {
        super(message);
    }

    public IDNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
