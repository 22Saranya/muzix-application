package com.stackroute.muzix.exceptions;
import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<String> exceptionhandler(Exception e) {
        return new ResponseEntity<>("erorr exception occured in Global " + e.getMessage(), HttpStatus.CONFLICT);
    }
}

