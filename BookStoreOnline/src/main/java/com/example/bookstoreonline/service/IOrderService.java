package com.example.bookstoreonline.service;

import com.example.bookstoreonline.model.Order;
import com.example.bookstoreonline.model.User;

public interface IOrderService {
    Order checkout(User user, String receiverName, String receiverAddress, String receiverPhone);
}
