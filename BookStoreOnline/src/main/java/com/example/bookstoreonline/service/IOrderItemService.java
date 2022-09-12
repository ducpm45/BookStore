package com.example.bookstoreonline.service;

import com.example.bookstoreonline.model.OrderItem;

public interface IOrderItemService {
//    void addNewOrderItem(Long bookId, Long orderItemId, Integer quantity);
    OrderItem addOrderItemFirstTime(Long bookId, String userEmail, Integer quantity);

    void addOrderItemToExistingOrder(Long bookId, String sessionToken, Integer quantity);

    void updateOrderItem(Long itemId, Integer quantity);

    void removeOrderItem(Long itemId, String sessionToken);
}
