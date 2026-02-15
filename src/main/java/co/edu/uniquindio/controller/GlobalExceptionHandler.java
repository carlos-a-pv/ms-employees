package co.edu.uniquindio.controller;

import co.edu.uniquindio.dto.GlobalHandlerDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.time.LocalDate;
import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<GlobalHandlerDTO> handleMethodNotAllowed(HttpRequestMethodNotSupportedException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(GlobalHandlerDTO.builder()
                        .timestamp(LocalDateTime.now())
                        .status("404")
                        .error("Resource not found")
                        .path("api/employees")
                        .build());
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<GlobalHandlerDTO> handle404(NoHandlerFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(GlobalHandlerDTO.builder()
                        .timestamp(LocalDateTime.now())
                        .status("404")
                        .error("Resource not found")
                        .path(ex.getRequestURL())
                .build());
    }
}
