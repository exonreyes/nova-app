package nova.infrastructure.empresa.persistence.exception;

public class UnidadNotFoundException extends RuntimeException {
    public UnidadNotFoundException(String message) {
        super(message);
    }
}
