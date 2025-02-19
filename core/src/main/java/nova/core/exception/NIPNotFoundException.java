package nova.core.exception;

public class NIPNotFoundException extends RuntimeException {
    public NIPNotFoundException(String message) {
        super(message);
    }

    public NIPNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NIPNotFoundException(Throwable cause) {
        super(cause);
    }
}
