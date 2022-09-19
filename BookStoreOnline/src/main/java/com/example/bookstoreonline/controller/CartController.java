package com.example.bookstoreonline.controller;

import com.example.bookstoreonline.model.Book;
import com.example.bookstoreonline.model.ShoppingCart;
import com.example.bookstoreonline.model.User;
import com.example.bookstoreonline.service.IBookService;
import com.example.bookstoreonline.service.IShoppingCartService;
import com.example.bookstoreonline.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.Objects;

@Controller
@Slf4j
public class CartController {
    @Autowired
    private IBookService bookService;
    @Autowired
    private IUserService userService;
    @Autowired
    private IShoppingCartService shoppingCartService;

    @GetMapping("/cart")
    public String viewCart(Model model, Principal principal, HttpSession session) {
        model.addAttribute("title", "Giỏ hàng");
        if (principal == null) {
            return "redirect:/login";
        }
        String userEmail = principal.getName();
        User user = userService.getUserByEmail(userEmail);
        ShoppingCart shoppingCart = shoppingCartService.getShoppingCartByUser(user);
        log.info("Duc shopping cart {}", shoppingCart);
        if (shoppingCart == null) {
            model.addAttribute("shoppingCartEmpty", "Không có sách nào trong giỏ hàng");
        } else {
            model.addAttribute("totalItems", shoppingCart.getCartItem());
            model.addAttribute("totalPrices", shoppingCart.getTotalPrices());
            model.addAttribute("shoppingCart", shoppingCart);
        }
        return "/user/cart";
    }

    @PostMapping("/add-to-cart")
    public String addItemToCart(Model model, @RequestParam("bookId") Long bookId,
                                @RequestParam(value = "quantity", required = false, defaultValue = "1") Integer quantity,
                                Principal principal) {
        if (principal == null) {
            return "redirect:/login";
        }
        Book book = bookService.getBookById(bookId);
        String userEmail = principal.getName();
        User user = userService.getUserByEmail(userEmail);
        ShoppingCart shoppingCart = shoppingCartService.addItemToCart(book, quantity, user);
        return "redirect:/";
    }

    @RequestMapping(value = "/update-cart", method = RequestMethod.POST, params = "action=update")
    public String changeQuantity(@RequestParam("quantity") int quantity,
                                 @RequestParam("bookId") Long bookID,
                                 Model model,
                                 Principal principal) {
        if (principal == null) {
            return "redirect:/login";
        } else {
            String userEmail = principal.getName();
            User user = userService.getUserByEmail(userEmail);
            Book book = bookService.getBookById(bookID);
            ShoppingCart shoppingCart = shoppingCartService.changeQuantityItemInCart(book, quantity, user);
            model.addAttribute("shoppingCart", shoppingCart);
            return "redirect:/cart";
        }
    }

    @RequestMapping(value = "/update-cart", method = RequestMethod.POST, params = "action=delete")
    public String deleteItemInCart(@RequestParam("bookId") Long bookId, Model model, Principal principal) {
        if (principal == null) {
            return "redirect:/login";
        } else {
            String userEmail = principal.getName();
            User user = userService.getUserByEmail(userEmail);
            Book book = bookService.getBookById(bookId);
            ShoppingCart shoppingCart = shoppingCartService.deleteItemInCart(book, user);
            model.addAttribute("shoppingCart", shoppingCart);
            return "redirect:/cart";
        }
    }
}
