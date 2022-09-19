package com.example.bookstoreonline.controller;

import com.example.bookstoreonline.model.Order;
import com.example.bookstoreonline.model.ShoppingCart;
import com.example.bookstoreonline.model.User;
import com.example.bookstoreonline.service.IOrderService;
import com.example.bookstoreonline.service.IShoppingCartService;
import com.example.bookstoreonline.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
@Slf4j
public class OrderController {
    @Autowired
    private IUserService userService;
    @Autowired
    private IOrderService orderService;
    @Autowired
    private IShoppingCartService shoppingCartService;

    @PostMapping("/checkout")
    public String checkout(Model model,
                           Principal principal,
                           @RequestParam("receiverName") String receiverName,
                           @RequestParam("receiverAddress") String receiverAddress,
                           @RequestParam("receiverPhone") String receiverPhone) {
        if (principal == null) {
            return "redirect:/login";
        }
        model.addAttribute("title", "Đặt hàng");
        String userEmail = principal.getName();
        User user = userService.getUserByEmail(userEmail);

        ShoppingCart shoppingCart = shoppingCartService.getShoppingCartByUser(user);
        if (receiverName == null || receiverName.trim().isEmpty()
                || receiverAddress == null || receiverAddress.trim().isEmpty()
                || receiverPhone == null || receiverPhone.trim().isEmpty()) {
            model.addAttribute("checkoutFailed", "Đặt hàng không thành công");
            shoppingCartService.deleteShoppingCart(shoppingCart);
        } else {
            Order order = orderService.checkout(user, receiverName, receiverAddress, receiverPhone);
            model.addAttribute("checkoutSuccess", "Đặt hàng thành công!");
            model.addAttribute("order", order);
        }
        return "/user/checkout";
    }
}
