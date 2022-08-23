package com.example.bookstoreonline.exception;

public class EmailIsExistedException extends RuntimeException{
    public EmailIsExistedException(String message) {
        super(message);
    }
}
