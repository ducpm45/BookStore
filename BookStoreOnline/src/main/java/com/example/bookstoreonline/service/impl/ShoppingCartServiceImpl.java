package com.example.bookstoreonline.service.impl;

import com.example.bookstoreonline.model.Book;
import com.example.bookstoreonline.model.CartItem;
import com.example.bookstoreonline.model.ShoppingCart;
import com.example.bookstoreonline.model.User;
import com.example.bookstoreonline.repository.CartItemRepository;
import com.example.bookstoreonline.repository.ShoppingCartRepository;
import com.example.bookstoreonline.service.IShoppingCartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Service
@Slf4j
public class ShoppingCartServiceImpl implements IShoppingCartService {
    @Autowired
    private ShoppingCartRepository shoppingCartRepository;
    @Autowired
    private CartItemRepository cartItemRepository;

    @Override
    public ShoppingCart addItemToCart(Book book, Integer quantity, User user) {
        ShoppingCart shoppingCart = shoppingCartRepository.getShoppingCartByUser(user);
        if (null == shoppingCart) {
            shoppingCart = shoppingCartRepository.save(new ShoppingCart());
        }
        Set<CartItem> cartItemSet = shoppingCart.getCartItem();
        CartItem cartItem = findCartItem(cartItemSet, book.getId());
        if (cartItemSet == null) {
            cartItemSet = new HashSet<>();
            cartItem = new CartItem();
            cartItem.setBook(book);
            cartItem.setTotalPrice(quantity * (book.getPrice() * (1 - book.getDiscount())));
            cartItem.setQuantity(quantity);
            cartItem.setShoppingCart(shoppingCart);
            cartItemSet.add(cartItem);
            log.info("CartItem {}", cartItem);

        } else {
            if (cartItem == null) {
                cartItem = new CartItem();
                cartItem.setBook(book);
                cartItem.setTotalPrice(quantity * (book.getPrice() * (1 - book.getDiscount())));
                cartItem.setQuantity(quantity);
                cartItem.setShoppingCart(shoppingCart);
                cartItemSet.add(cartItem);
                log.info("CartItem {}", cartItem);
            } else {
                cartItem.setQuantity(cartItem.getQuantity() + quantity);
                cartItem.setTotalPrice(cartItem.getTotalPrice() + (quantity * (book.getPrice() * (1 - book.getDiscount()))));

                log.info("CartItem {}", cartItem);
            }
        }
        shoppingCart.setCartItem(cartItemSet);
        int totalItems = totalItems(cartItemSet);
        double totalPrice = totalPrice(cartItemSet);
        shoppingCart.setTotalItems(totalItems);
        shoppingCart.setTotalPrices(totalPrice);
        shoppingCart.setUser(user);
        log.info("Shopping Cart {}", shoppingCart);
        return shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public ShoppingCart getShoppingCartByUser(User user) {

        return shoppingCartRepository.getShoppingCartByUser(user);
    }

    @Override
    public ShoppingCart changeQuantityItemInCart(Book book, int quantity, User user) {
        ShoppingCart shoppingCart = shoppingCartRepository.getShoppingCartByUser(user);
        Set<CartItem> cartItemSet = shoppingCart.getCartItem();
        CartItem cartItem = findCartItem(cartItemSet, book.getId());
        cartItem.setQuantity(quantity);
        cartItem.setTotalPrice(quantity * book.getPrice() * (1 - book.getDiscount()));
        cartItemRepository.save(cartItem);
        int totalItems = totalItems(cartItemSet);
        double totalPrice = totalPrice(cartItemSet);
        shoppingCart.setTotalItems(totalItems);
        shoppingCart.setTotalPrices(totalPrice);
        return shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public ShoppingCart deleteItemInCart(Book book, User user) {
        ShoppingCart shoppingCart = shoppingCartRepository.getShoppingCartByUser(user);
        Set<CartItem> cartItemSet = shoppingCart.getCartItem();
        CartItem cartItem = findCartItem(cartItemSet, book.getId());
        cartItemSet.remove(cartItem);
        cartItemRepository.delete(cartItem);
        int totalItems = totalItems(cartItemSet);
        double totalPrices = totalPrice(cartItemSet);
        shoppingCart.setTotalItems(totalItems);
        shoppingCart.setTotalPrices(totalPrices);
        return shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public void deleteShoppingCart(ShoppingCart shoppingCart) {
        shoppingCartRepository.delete(shoppingCart);
    }

    private CartItem findCartItem(Set<CartItem> cartItemSet, Long bookId) {
        if (cartItemSet == null) {
            return null;
        }
        CartItem cartItem = null;
        for (CartItem item : cartItemSet) {
            if (Objects.equals(item.getBook().getId(), bookId)) {
                cartItem = item;
            }
        }
        return cartItem;
    }

    private int totalItems(Set<CartItem> cartItemSet) {
        int totalItems = 0;
        for (CartItem item : cartItemSet) {
            totalItems += item.getQuantity();
        }
        return totalItems;
    }

    private double totalPrice(Set<CartItem> cartItemSet) {
        double totalPrice = 0.0;
        for (CartItem item : cartItemSet) {
            totalPrice += item.getTotalPrice();
        }
        return totalPrice;
    }
}
