package com.example.bookstoreonline.service;

import com.example.bookstoreonline.dto.NewUserDTO;
import com.example.bookstoreonline.model.User;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

public interface IUserService {
    void registerNewUser(NewUserDTO newUserDTO, String siteURL) throws MessagingException, UnsupportedEncodingException;
    User getUserByEmail(String email);
    void sendVerificationCodeToEmail(User user, String siteURL) throws MessagingException, UnsupportedEncodingException;
    boolean verified(String verifyCode);
}
