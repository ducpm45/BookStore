package com.example.bookstoreonline.service.impl;

import com.example.bookstoreonline.model.OrderItem;
import com.example.bookstoreonline.repository.OrderItemRepository;
import com.example.bookstoreonline.service.IOrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderItemServiceImpl implements IOrderItemService {
    @Autowired
    private OrderItemRepository orderItemRepository;
    @Override
    public void addNewOrderItem(Long bookId, Long orderItemId, Integer quantity) {
        OrderItem newOrderItem = OrderItem.builder()

                .build();
    }
}
