package com.example.bookstoreonline.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class NewUserDTO {
    private String email;
    private String password;
    private String fullName;
    private String address;
    private String phone;
}
