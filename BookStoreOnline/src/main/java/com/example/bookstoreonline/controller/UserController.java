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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.security.Principal;

@Controller
@Slf4j
public class UserController {
    @Autowired
    private IUserService userService;
    @GetMapping("/user")
    public String showUserPage(Model model, Principal principal) {
        if(principal == null) {
            return "redirect:/login";
        }
        model.addAttribute("title", "Trang cá nhân");
        String userEmail = principal.getName();
        User user = userService.getUserByEmail(userEmail);
        model.addAttribute("userFullName", user.getFullName());
        return "/user/user";
    }
    @GetMapping("/login")
    public String showLoginPage(Model model) {
        model.addAttribute("title", "Đăng nhập");
        return "login";
    }

    @GetMapping("/register")
    public String showRegisterPage(Model model) {
        model.addAttribute("title", "Đăng ký");
        model.addAttribute("newUserDTO", new NewUserDTO());
        return "register";
    }

    @PostMapping("/register-new-user")
    public String registerNewUser(@Valid @ModelAttribute("newUserDTO") NewUserDTO newUserDTO,
                                  BindingResult result,
                                  Model model,
                                  HttpServletRequest request) throws MessagingException, UnsupportedEncodingException {
        log.info("NewUserDTO: {}", newUserDTO);
        if (result.hasErrors()) {
            model.addAttribute("newUserDTO", newUserDTO);
            log.info("Result: {}", result);
            return "register";
        }
        String email = newUserDTO.getEmail();
        User user = userService.getUserByEmail(email);
        if (null != user) {
            model.addAttribute("newUserDTO", newUserDTO);
            log.info("Email existed {}", email);
            model.addAttribute("existingEmail", "Email này đã tồn tại!");
            return "register";
        }
        userService.registerNewUser(newUserDTO, getSiteURL(request));
        model.addAttribute("title", "Xác minh");
        return "email-verification";
    }

    @GetMapping("/verify")
    public String verifyUser(Model model, @Param("code") String code) {
        if (userService.verified(code)) {
            model.addAttribute("title", "Xác minh thành công");
            return "verify-success";
        } else {
            model.addAttribute("title", "Xác minh thất bại");
            return "verify-failed";
        }
    }

    private String getSiteURL(HttpServletRequest request) {
        String siteURL = request.getRequestURL().toString();
        return siteURL.replace(request.getServletPath(), "");
    }
}
