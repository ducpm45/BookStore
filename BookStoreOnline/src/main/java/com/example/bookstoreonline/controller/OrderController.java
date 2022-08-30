package com.example.bookstoreonline.controller;

import com.example.bookstoreonline.model.Book;
import com.example.bookstoreonline.model.Order;
import com.example.bookstoreonline.model.User;
import com.example.bookstoreonline.service.IBookService;
import com.example.bookstoreonline.service.IOrderItemService;
import com.example.bookstoreonline.service.IOrderService;
import com.example.bookstoreonline.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/bookstore")
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
    public String showCartPage(Model model, Principal principal) {
        if(null != principal) {
            model.addAttribute("username", principal.getName());
        }
        return "/user/cart";
    }
    @PostMapping("/add-to-cart")
    public String addOneToCart(Model model, @RequestBody() Long bookId,
                            @RequestBody() Long orderId,
                            Principal principal) {

        Book book = bookService.getBookById(bookId);
        Order order = orderService.getOrderById(orderId);
        User user = userService.getUserByEmail(principal.getName());
        return "index";
    }
}
