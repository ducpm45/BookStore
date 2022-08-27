package com.example.bookstoreonline.controller;

import com.example.bookstoreonline.dto.NewUserDTO;
import com.example.bookstoreonline.model.User;
import com.example.bookstoreonline.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

@Controller
@Slf4j
public class UserController {
    @Autowired
    private IUserService userService;
    @GetMapping("/login")
    public String showLoginPage() {
        return "/user/login";
    }
    @GetMapping("/register")
    public String showRegisterPage(Model model) {
        model.addAttribute("newUserDTO", new NewUserDTO());
        return "/user/register";
    }

    @PostMapping("/register-new-user")
    public String registerNewUser(@Validated @ModelAttribute("newUserDTO") NewUserDTO newUserDTO,
                                  BindingResult result,
                                  Model model,
                                  HttpServletRequest request) throws MessagingException, UnsupportedEncodingException {
        log.info("NewUserDTO: {}", newUserDTO);
        if (result.hasErrors()) {
            model.addAttribute("newUserDTO", newUserDTO);
            log.info("Result: {}", result);
            return "/user/register";
        }
            String email = newUserDTO.getEmail();
            User user = userService.getUserByEmail(email);
            if (null != user) {
                model.addAttribute("newUserDTO", newUserDTO);
                log.info("Email existed {}", email);
                model.addAttribute("existingEmail", "Email này đã tồn tại!");
                return "/user/register";
            }
            userService.registerNewUser(newUserDTO, getSiteURL(request));
            return "/user/email-verification";
    }

    @GetMapping("/verify")
    public String verifyUser(Model model, @Param("code") String code) {
        if(userService.verified(code)) {
            return "/user/verify-success";
        } else {
            return "/user/verify-failed";
        }
    }

    private String getSiteURL(HttpServletRequest request) {
        String siteURL = request.getRequestURL().toString();
        return siteURL.replace(request.getServletPath(), "");
    }
}
