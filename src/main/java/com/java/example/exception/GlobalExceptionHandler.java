package com.java.example.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.java.example.model.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = TodoNotFoundException.class)
    @JsonProperty("errors")
    public ResponseEntity<Map<String, List<Error>>> todoNotFoundException(TodoNotFoundException ex) {
        List<Error> errors = new ArrayList();
        Error error = new Error();
        error.setCode("Object not found");
        error.setMessage(ex.getMessage());
        errors.add(error);
        return new ResponseEntity<>(getErrorsMap(errors), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @JsonProperty("errors")
    public ResponseEntity<Map<String, List<Error>>> handleValidationException(MethodArgumentNotValidException ex) {
        List<Error> errors = new ArrayList();
        ex.getBindingResult().getFieldErrors().forEach((fieldError) -> {
            Error error = new Error();
            error.setCode(fieldError.getCode());
            error.setMessage(fieldError.getDefaultMessage());
            errors.add(error);
        });
        return new ResponseEntity<>(getErrorsMap(errors), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({DateTimeParseException.class})
    @JsonProperty("errors")
    public ResponseEntity<Map<String, List<Error>>> handleDateFormatException(DateTimeParseException ex) {
        List<Error> errors = new ArrayList();
        Error error = new Error();
        error.setCode("InValid DateTime");
        error.setMessage(ex.getMessage());
        errors.add(error);
        return new ResponseEntity<>(getErrorsMap(errors), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({HttpMessageNotReadableException.class})
    @JsonProperty("errors")
    public ResponseEntity<Map<String, List<Error>>> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        List<Error> errors = new ArrayList();
        Error error = new Error();
        error.setCode("Invalid Request Body");
        error.setMessage(ex.getMessage());
        errors.add(error);
        return new ResponseEntity<>(getErrorsMap(errors), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private Map<String, List<Error>> getErrorsMap(List<Error> errors) {
        Map<String, List<Error>> errorResponse = new HashMap<>();
        errorResponse.put("errors", errors);
        return errorResponse;
    }
}
