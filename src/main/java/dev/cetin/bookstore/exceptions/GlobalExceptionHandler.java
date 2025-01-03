package dev.cetin.bookstore.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ExceptionResponse> handleException(BookException bookException) {
        log.error("Book error occurred", bookException);
        return new ResponseEntity<>(new ExceptionResponse(bookException.getMessage(),bookException.getHttpStatus().value(), LocalDateTime.now()), bookException.getHttpStatus());
    }
    @ExceptionHandler
    public ResponseEntity<ExceptionResponse> handleException(AuthorException authorException) {
        log.error("Author error occurred", authorException);
        return new ResponseEntity<>(new ExceptionResponse(authorException.getMessage(),authorException.getHttpStatus().value(), LocalDateTime.now()), authorException.getHttpStatus());
    }
    @ExceptionHandler
    public ResponseEntity<ExceptionResponse> handleException(Exception exception) {
        log.error("Book error occurred", exception);
        return new ResponseEntity<>(new ExceptionResponse(exception.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR.value(), LocalDateTime.now()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
