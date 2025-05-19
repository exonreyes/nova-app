package nova.global.exception;

import lombok.extern.slf4j.Slf4j;
import nova.commons.Data;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLIntegrityConstraintViolationException;

@Slf4j
@ControllerAdvice
public class DatabaseExceptionHandler {

    // -------------------------------------
    // Errores de base de datos
    // -------------------------------------
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<Void> handleSQLIntegrityConstraintViolation(SQLIntegrityConstraintViolationException ex) {
        ErrorResponse response = ErrorResponse.builder(ex.getCause(), HttpStatus.CONFLICT, "No se pudo procesar").build();
        return ResponseEntity.internalServerError().build();
    }

    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<Data<Void>> handleInvalidDataAccess(DataAccessException ex) {

        ErrorResponse response = ErrorResponse.builder(ex.getCause(), HttpStatus.CONFLICT, "No se pudo procesar").build();
        return ResponseEntity.internalServerError().build();
    }
}