package com.bigs.api.global.handler;


import com.bigs.api.global.response.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;


@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> commonException(Exception exception) {
        String message = exception.getMessage();

        return ResponseEntity.internalServerError()
                .body(ApiResponse.error(message));
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiResponse> commonException(RuntimeException exception) {
        String message = exception.getMessage();

        return ResponseEntity.badRequest()
                .body(ApiResponse.error(message));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse> methodArgumentValidException(MethodArgumentNotValidException exception) {
        List<String> errorMessages = exception.getAllErrors()
                .stream()
                .map(objectError -> objectError.getDefaultMessage())
                .toList();

        return ResponseEntity.badRequest().body(ApiResponse.error(errorMessages));
    }
}
