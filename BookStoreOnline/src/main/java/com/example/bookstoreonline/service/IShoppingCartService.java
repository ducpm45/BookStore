package com.example.bookstoreonline.service;

import com.example.bookstoreonline.model.Book;
import com.example.bookstoreonline.model.ShoppingCart;
import com.example.bookstoreonline.model.User;

public interface IShoppingCartService {
    ShoppingCart addItemToCart(Book book, Integer quantity, User user);
    ShoppingCart getShoppingCartByUser(User user);

    ShoppingCart changeQuantityItemInCart(Book book, int quantity, User user);

    ShoppingCart deleteItemInCart(Book book, User user);

    void deleteShoppingCart(ShoppingCart shoppingCart);
}
