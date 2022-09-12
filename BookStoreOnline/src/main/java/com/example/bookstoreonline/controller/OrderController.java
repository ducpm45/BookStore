package com.example.bookstoreonline.controller;

import com.example.bookstoreonline.model.Book;
import com.example.bookstoreonline.model.Order;
import com.example.bookstoreonline.model.User;
import com.example.bookstoreonline.service.IBookService;
import com.example.bookstoreonline.service.IOrderItemService;
import com.example.bookstoreonline.service.IOrderService;
import com.example.bookstoreonline.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@Slf4j
public class OrderController {
    @Autowired
    private IOrderService orderService;
    @Autowired
    private IBookService bookService;
    @Autowired
    private IUserService userService;
    @Autowired
    private IOrderItemService orderItemService;
    @GetMapping("/cart")
    public String showCart(Model model, Principal principal) {
        if(null == principal) {
            return "redirect:/login";
        }
        model.addAttribute("title", "Giỏ hàng");
        return "/user/cart";
    }
    @GetMapping("/add-to-cart/{bookId}/{orderId}")
    public String addOneToCart(Model model, @PathVariable("bookId") Long bookId,
                            @PathVariable("orderId") Long orderId,
                            Principal principal) {
        if(null == principal) {
            return "redirect:/login";
        }
        String userEmail = principal.getName();
        log.info("userEmail: {}", userEmail);
        Order order = orderService.getOrderById(orderId);
        if(order == null) {
            orderItemService.addOrderItemFirstTime(bookId, userEmail, 1);
        }
        return "index";
    }
}
