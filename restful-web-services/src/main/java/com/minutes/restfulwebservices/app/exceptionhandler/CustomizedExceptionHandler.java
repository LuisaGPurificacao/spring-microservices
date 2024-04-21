package com.minutes.restfulwebservices.app.exceptionhandler;

import com.minutes.restfulwebservices.app.dto.response.ErrorResponse;
import com.minutes.restfulwebservices.cross.exception.UserNotFoundException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;

@ControllerAdvice
public class CustomizedExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
        return buildResponse(ex.getMessage(), request, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<Object> handleUserNotFoundException(Exception ex, WebRequest request) {
        return buildResponse(ex.getMessage(), request, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<String> errorsList = ex.getFieldErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).toList();
        String errorMessage = String.join(", ", errorsList);
        return buildResponse(errorMessage, request, HttpStatus.BAD_REQUEST);
    }

    private static ResponseEntity<Object> buildResponse(String message, WebRequest request, HttpStatus notFound) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .message(message)
                .details(request.getDescription(false))
                .build();

        return new ResponseEntity<>(errorResponse, notFound);
    }

}
