package com.example.bookstoreonline.service.impl;

import com.example.bookstoreonline.dto.NewUserDTO;
import com.example.bookstoreonline.model.User;
import com.example.bookstoreonline.repository.UserRepository;
import com.example.bookstoreonline.service.IUserService;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JavaMailSender mailSender;
    @Override
    public void registerNewUser(NewUserDTO newUserDTO, String siteURL) throws MessagingException, UnsupportedEncodingException {
        String encodePassword =passwordEncoder.encode(newUserDTO.getPassword());
        User newUser = User.builder()
                .email(newUserDTO.getEmail())
                .password(encodePassword)
                .address(newUserDTO.getAddress())
                .fullName(newUserDTO.getFullName())
                .phone(newUserDTO.getPhone())
                .role("CUSTOMER")
                .build();

        String randomCode = RandomString.make(128);
        newUser.setVerificationCode(randomCode);
        newUser.setEnable(false);
        userRepository.save(newUser);
        sendVerificationCodeToEmail(newUser, siteURL);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }

    @Override
    public void sendVerificationCodeToEmail(User user, String siteURL) throws MessagingException, UnsupportedEncodingException {
        String toAddressMail = user.getEmail();
        String fromAddressMail ="ducpmfx11325@funix.edu.vn";
        String senderName = "BOOKSTORE";
        String subject = "Xin hãy xác minh đăng ký của bạn !";
        String content = "Xin chào [[fullName]], <br>"
                + "Vào lúc [[time]], bạn đã sử dụng địa chỉ email này để đăng ký tài khoản tại BookStore. <br>"
                + "Xin hãy click vào đường dẫn dưới đây để xác minh và hoàn tất việc đăng ký tài khoản của bạn. <br>"
                + "<h3><a href=\"[[URL]]\" target=\"_self\">VERIFY</a></h3>"
                + "Cảm ơn, chúc bạn và gia đình một ngày vui vẻ! <br>"
                + "Trân trọng, BOOKSTORE";
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom(fromAddressMail, senderName);
        helper.setTo(toAddressMail);
        helper.setSubject(subject);

        content = content.replace("[[fullName]]", user.getFullName());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String time = LocalDateTime.now().format(formatter);
        content = content.replace("[[time]]", time);
        String verifyURL = siteURL + "/bookstore/verify?code=" + user.getVerificationCode();
        content = content.replace("[[URL]]", verifyURL);
        helper.setText(content, true);
        mailSender.send(message);
    }

    @Override
    public boolean verified(String verifyCode) {
        User user = userRepository.getUserByVerificationCode(verifyCode);
        if(null == user || user.getEnable()) {
            return false;
        } else {
            user.setVerificationCode(null);
            user.setEnable(true);
            userRepository.save(user);
            return true;
        }
    }
}
