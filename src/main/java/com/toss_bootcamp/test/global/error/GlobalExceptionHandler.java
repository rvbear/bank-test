package com.toss_bootcamp.test.global.error;

import com.toss_bootcamp.test.domain.account.controller.AccountController;
import com.toss_bootcamp.test.domain.user.controller.UserController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

//@RestControllerAdvice(annotations = {RestController.class}, basePackageClasses = {AccountController.class, UserController.class})
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Map<String, Object>> handleItemNotFoundException(final NoSuchElementException ex) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .message(ex.getMessage())
                .time(LocalDateTime.now())
                .build();

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("success", false);
        responseMap.put("error", errorResponse);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseMap);
    }
}
