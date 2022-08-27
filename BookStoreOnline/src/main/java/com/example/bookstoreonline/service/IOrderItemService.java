package com.example.bookstoreonline.service;

public interface IOrderItemService {
    void addNewOrderItem(Long bookId, Long orderItemId, Integer quantity);
}
