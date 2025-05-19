package nova.global.exception;

import jakarta.validation.ConstraintViolationException;
import nova.exception.IDNotFoundException;
import org.hibernate.validator.internal.engine.path.PathImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ValidationExceptionHandler {
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Map<String, Object>> handleConstraintViolationException(ConstraintViolationException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getConstraintViolations().forEach(violation -> errors.put(((PathImpl) violation.getPropertyPath()).getLeafNode().getName(), violation.getMessage()));

        Map<String, Object> response = new HashMap<>();
        response.put("code", "VALIDATION_ERROR");
        response.put("message", "Error de validación");
        response.put("title", "Los datos proporcionados no son válidos.");
        response.put("data", errors);

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ProblemDetail> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);

        problemDetail.setTitle("Error de validación");
        problemDetail.setDetail("Los datos proporcionados no son válidos");
        problemDetail.setProperty("code", "VALIDATION_ERROR");

        Map<String, String> errors = new HashMap<>();
        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            errors.putIfAbsent(fieldError.getField(), fieldError.getDefaultMessage());
        }

        if (!errors.isEmpty()) {
            problemDetail.setProperty("errors", errors); // cambio a "errors" como nombre plural y más claro
        }

        return ResponseEntity.badRequest().body(problemDetail);
    }


    @ExceptionHandler(IDNotFoundException.class)
    public ResponseEntity<ProblemDetail> idNotFoundException(IDNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getMessage()));
    }

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<ProblemDetail> illegalState(IllegalStateException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ProblemDetail.forStatusAndDetail(HttpStatus.CONFLICT, e.getMessage()));
    }
}