package nova.ticket.exception;

public class TicketSaveException extends RuntimeException {
    public TicketSaveException(String message, Throwable cause) {
        super(message, cause);
    }
}
