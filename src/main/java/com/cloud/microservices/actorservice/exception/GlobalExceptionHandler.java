package com.cloud.microservices.actorservice.exception;

import com.cloud.dependencies.dtoservice.exception.ErrorResponse;
import com.cloud.dependencies.dtoservice.exception.ResourceNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@ResponseStatus
@RestControllerAdvice
public class GlobalExceptionHandler {

    private ErrorResponse errorResponse(List<String> errors, String path, String errorCode) {
        return ErrorResponse.builder()
                .timestamp( LocalDateTime.now() )
                .errorMessage( errors )
                .path( path )
                .errorCode( errorCode )
                .build();
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException exception,
                                                                         WebRequest webRequest) {
        log.info( "Start exception :: handleResourceNotFoundException: [{}, {}]",
                exception.getMessage(), webRequest );

        ErrorResponse errorResponse = errorResponse( Collections.singletonList( exception.getMessage() ),
                webRequest.getDescription( false ), "RESOURCE_NOT_FOUND" );

        return new ResponseEntity<>( errorResponse, HttpStatus.NOT_FOUND );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationErrors(MethodArgumentNotValidException exception,
                                                                WebRequest webRequest) {
        log.info( "Start exception :: handleResourceNotFoundException: [{}, {}]",
                exception.getMessage(), webRequest );

        List<String> fieldErrors = exception.getBindingResult().getFieldErrors()
                .stream()
                .map( fieldError -> fieldError.getField() + ": " + fieldError.getDefaultMessage() )
                .collect( Collectors.toList() );

        ErrorResponse errorResponse = errorResponse( fieldErrors,
                webRequest.getDescription( false ), "VALIDATION_FIELD_ERROR" );

        return new ResponseEntity<>( errorResponse, HttpStatus.BAD_REQUEST );
    }

}