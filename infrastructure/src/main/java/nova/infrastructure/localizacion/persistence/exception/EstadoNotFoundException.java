package nova.infrastructure.localizacion.persistence.exception;

public class EstadoNotFoundException extends RuntimeException {
    public EstadoNotFoundException(String message) {
        super(message);
    }

    public EstadoNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
