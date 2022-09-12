package com.example.bookstoreonline.service.impl;

import com.example.bookstoreonline.model.Order;
import com.example.bookstoreonline.model.User;
import com.example.bookstoreonline.repository.OrderItemRepository;
import com.example.bookstoreonline.repository.OrderRepository;
import com.example.bookstoreonline.repository.UserRepository;
import com.example.bookstoreonline.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;
    @Override
    public Order getOrderById(Long orderId) {
        if(!orderRepository.findById(orderId).isPresent()) {
            return null;
        }
        return orderRepository.findById(orderId).get();
    }
}
