package com.example.bookstoreonline.service;

import com.example.bookstoreonline.model.Order;

public interface IOrderService {
    Order getOrderById(Long orderId);
    void addOrderItemFirstTime(Long productId, String sessionToken, Integer quantity);

    void addOrderItemToExistingOrder(Long productId, String sessionToken, Integer quantity);

    void updateOrderItem(Long itemId, Integer quantity);

    void removeOrderItem(Long itemId, String sessionToken);
}
