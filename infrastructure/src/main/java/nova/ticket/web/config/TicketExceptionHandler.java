package nova.ticket.web.config;

import nova.ticket.exception.FolioDuplicadoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TicketExceptionHandler {
    @ExceptionHandler(FolioDuplicadoException.class)
    public ResponseEntity<String> handleFolioDuplicadoException(FolioDuplicadoException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }
}
