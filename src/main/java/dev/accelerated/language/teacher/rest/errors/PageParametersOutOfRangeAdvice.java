package dev.accelerated.language.teacher.rest.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.URI;

@RestControllerAdvice
public class PageParametersOutOfRangeAdvice {
    @ExceptionHandler(PageParametersOutOfRangeException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    ErrorResponse pageOutOfRangeHandler(PageParametersOutOfRangeException problem) {
        var builder = ErrorResponse.builder(problem, HttpStatus.NOT_FOUND, problem.getMessage());
        builder.instance(URI.create("/problems/page-out-of-range"));

        return builder.build();
    }
}
