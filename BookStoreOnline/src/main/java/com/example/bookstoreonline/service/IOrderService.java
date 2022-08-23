package com.example.bookstoreonline.service;

public interface IOrderService {
    void addOrderItemFirstTime(Long productId, String sessionToken, Integer quantity);

    void addOrderItemToExistingOrder(Long productId, String sessionToken, Integer quantity);
}
