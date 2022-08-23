package com.example.bookstoreonline.controller;

import com.example.bookstoreonline.exception.EmailIsExistedException;
import com.example.bookstoreonline.exception.ResourceNotFoundException;
import com.example.bookstoreonline.model.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

import static com.example.bookstoreonline.constant.ExceptionCode.EMAIL_IS_EXISTED;
import static com.example.bookstoreonline.constant.ExceptionCode.RESOURCE_NOT_FOUND;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = ResourceNotFoundException.class)
    protected ResponseEntity<ErrorMessage> handlerResourceNotFoundException(ResourceNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ErrorMessage.builder().timestamp(LocalDateTime.now())
                        .exceptionCode(RESOURCE_NOT_FOUND)
                        .message(e.getMessage())
                        .build());
    }

    @ExceptionHandler(value = EmailIsExistedException.class)
    protected ResponseEntity<ErrorMessage> handlerEmailIsExistedException(EmailIsExistedException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ErrorMessage.builder().timestamp(LocalDateTime.now())
                        .exceptionCode(EMAIL_IS_EXISTED)
                        .message(e.getMessage())
                        .build());
    }
}
