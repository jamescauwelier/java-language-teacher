package dev.accelerated.language.teacher.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.validation.FieldError;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalControllerExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalControllerExceptionHandler.class);

    @Override
    protected @NonNull ResponseEntity<Object> handleMethodArgumentNotValid(@NonNull MethodArgumentNotValidException ex, @NonNull HttpHeaders headers, @NonNull HttpStatusCode status, @NonNull WebRequest request) {

        // construct a map of field to validation error messages
        Map<String, String> orderErrorMessages = new HashMap<>();
        for (FieldError error : ex.getFieldErrors()) {
            orderErrorMessages.put(
                    String.format("%s.%s", ex.getObjectName(), error.getField()),
                    error.getDefaultMessage()
            );
        }

        // builds an error response using constructed validation errors
        ErrorResponse.Builder builder = ErrorResponse.builder(ex, HttpStatus.BAD_REQUEST, "Failed to validate requested " + ex.getObjectName());
        builder.type(URI.create("/problems/validation_error"));
        builder.property("validation_errors", orderErrorMessages);

        // bringing it all together in ResponseEntity
        ErrorResponse response = builder.build();
        return ResponseEntity
                .badRequest()
                .body(response.getBody());
    }
}
