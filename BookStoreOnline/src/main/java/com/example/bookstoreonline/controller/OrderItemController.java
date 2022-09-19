package com.example.bookstoreonline.controller;

import com.example.bookstoreonline.model.Order;
import com.example.bookstoreonline.service.IOrderItemService;
import com.example.bookstoreonline.service.IOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;

@Controller
@Slf4j
public class OrderItemController {
    @Autowired
    private IOrderItemService orderItemService;
    @Autowired
    private IOrderService orderService;
//
//    @GetMapping("/add-to-cart/{bookId}/{orderId}")
//    public String addOneToCart(Model model, @PathVariable("bookId") Long bookId,
//                               @PathVariable("orderId") Long orderId,
//                               Principal principal) {
//        if(null == principal) {
//            return "redirect:/login";
//        }
//        String userEmail = principal.getName();
//        log.info("userEmail: {}", userEmail);
//        Order order = orderService.getOrderById(orderId);
//        if(order == null) {
//            Long newOrderId = orderItemService.addOrderItemFirstTime(bookId, userEmail, 1);
//
//            model.addAttribute("newOrderId", newOrderId);
//        }
//        return "index";
//    }
}
