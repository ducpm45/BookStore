package com.example.bookstoreonline.controller;

import com.example.bookstoreonline.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@Controller
@RequestMapping("/bookstore")
public class OrderController {
    @Autowired
    private IOrderService orderService;

    @PostMapping("/add-to-cart")
    public String addToCart(HttpServletRequest request, @RequestParam("productId") Long productId,
                            @RequestParam("quantity") Integer quantity) {
        String sessionToken = (String) request.getSession().getAttribute("sessionToken");
        if(null == sessionToken) {
            sessionToken = UUID.randomUUID().toString();
            request.getSession().setAttribute("sessionToken", sessionToken);
            orderService.addOrderItemFirstTime(productId, sessionToken, quantity);
        } else {
            orderService.addOrderItemToExistingOrder(productId, sessionToken, quantity);
        }
        return "redirect:/bookstore";
    }


}
