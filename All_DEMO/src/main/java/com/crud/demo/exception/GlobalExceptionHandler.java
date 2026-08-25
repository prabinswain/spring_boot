package com.crud.demo.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;

@RestControllerAdvice // common behavior for all the Controller
public class GlobalExceptionHandler {


    @ExceptionHandler(DuplicateEmailEntryException.class)
    public ResponseEntity<Object> duplicateEmailEntryExceptionHandler(DuplicateEmailEntryException exception,
                                                                      HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                        .body(new ErrorResponse(
                        LocalDateTime.now(),
                        HttpStatus.CONFLICT.value(),
                        HttpStatus.CONFLICT.getReasonPhrase(),
                        exception.getMessage(),
                        request.getRequestURI()));

    }

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<ErrorResponse> handlerStudentNotFoundException(StudentNotFoundException exception,
                                                                         HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new ErrorResponse(
                        LocalDateTime.now(),
                        HttpStatus.NOT_FOUND.value(),
                        HttpStatus.NOT_FOUND.getReasonPhrase(),
                        exception.getMessage(),
                        request.getRequestURI()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationErrorResponse> handlerMethodArgumentNotValidException(MethodArgumentNotValidException exception , HttpServletRequest request) {

        // to get default errors messages
        HashMap<String ,String> fieldErrors = new HashMap<>();
        exception.getBindingResult().getFieldErrors()
                .forEach( fieldError -> fieldErrors.put(fieldError.getField() , fieldError.getDefaultMessage()));

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(new ValidationErrorResponse(
                        LocalDateTime.now(),
                        HttpStatus.BAD_REQUEST.value(),
                        HttpStatus.BAD_REQUEST.getReasonPhrase(),
                        "Validation failed",
                        request.getRequestURI()
                        ,fieldErrors));
    }
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<ErrorResponse> parentException(Exception exception , HttpServletRequest request) {
//
//        return ResponseEntity.status(
//                        HttpStatus.INTERNAL_SERVER_ERROR).
//                        body(new ErrorResponse(
//                        LocalDateTime.now(),
//                        HttpStatus.INTERNAL_SERVER_ERROR.value(),
//                        HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
//                        "Something went wrong, please try again later.",
//                        request.getRequestURI()));
//    }

}
