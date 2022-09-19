package com.example.bookstoreonline.repository;

import com.example.bookstoreonline.model.ShoppingCart;
import com.example.bookstoreonline.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
    ShoppingCart getShoppingCartByUser(User user);
}
