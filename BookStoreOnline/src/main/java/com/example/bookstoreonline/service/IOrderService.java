package com.example.bookstoreonline.service;

import com.example.bookstoreonline.model.Order;

public interface IOrderService {
    Order getOrderById(Long orderId);

}
