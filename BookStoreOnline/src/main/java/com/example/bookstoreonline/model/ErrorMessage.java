package com.example.bookstoreonline.model;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ErrorMessage {
    private LocalDateTime timestamp;
    private String exceptionCode;
    private String message;
}
