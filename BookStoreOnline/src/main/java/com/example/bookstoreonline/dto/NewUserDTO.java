package com.example.bookstoreonline.dto;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class NewUserDTO {
    @Email(message = "Email không đúng định dạng!")
    private String email;
    @NotBlank(message = "Mật khẩu không được để trống!")
    @Size(min = 3, max = 10, message = "Mật khẩu phải dài từ 3-10 kí tự!")
    private String password;
    @NotBlank(message = "Họ tên không được để trống!")
    private String fullName;
    @NotBlank(message = "Địa chỉ không được để trống!")
    private String address;
    @NotBlank(message = "Số điện thoại không được để trống!")
    @Size(min = 10, max = 10, message = "Số điện thoại phải đủ 10 chữ số!")
    private String phone;
}
