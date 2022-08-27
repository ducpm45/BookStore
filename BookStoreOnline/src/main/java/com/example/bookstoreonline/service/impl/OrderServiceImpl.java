package com.example.bookstoreonline.service.impl;

import com.example.bookstoreonline.model.Order;
import com.example.bookstoreonline.repository.OrderRepository;
import com.example.bookstoreonline.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Override
    public Order getOrderById(Long orderId) {
        if(!orderRepository.findById(orderId).isPresent()) {
            return null;
        }
        return orderRepository.findById(orderId).get();
    }

    @Override
    public void addOrderItemFirstTime(Long productId, String sessionToken, Integer quantity) {

    }

    @Override
    public void addOrderItemToExistingOrder(Long productId, String sessionToken, Integer quantity) {

    }

    @Override
    public void updateOrderItem(Long itemId, Integer quantity) {

    }

    @Override
    public void removeOrderItem(Long itemId, String sessionToken) {

    }
}
