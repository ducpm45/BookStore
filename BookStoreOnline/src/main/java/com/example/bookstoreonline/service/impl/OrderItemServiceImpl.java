package com.example.bookstoreonline.service.impl;

import com.example.bookstoreonline.model.Book;
import com.example.bookstoreonline.model.Order;
import com.example.bookstoreonline.model.OrderItem;
import com.example.bookstoreonline.model.User;
import com.example.bookstoreonline.repository.BookRepository;
import com.example.bookstoreonline.repository.OrderItemRepository;
import com.example.bookstoreonline.repository.OrderRepository;
import com.example.bookstoreonline.repository.UserRepository;
import com.example.bookstoreonline.service.IOrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OrderItemServiceImpl implements IOrderItemService {
    @Autowired
    private OrderItemRepository orderItemRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private BookRepository bookRepository;
    @Override
    public OrderItem addOrderItemFirstTime(Long bookId, String userEmail, Integer quantity) {
        User user = userRepository.getUserByEmail(userEmail);
        Order order = Order.builder()
                .orderDate(LocalDateTime.now())
                .user(user)
                .build();
        Order newOrder = orderRepository.save(order);
        Book book = bookRepository.getById(bookId);
        OrderItem orderItem = OrderItem.builder()
                .book(book)
                .quantity(1)
                .order(newOrder)
                .build();
        return orderItemRepository.save(orderItem);
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
//    @Override
//    public void addNewOrderItem(Long bookId, Long orderItemId, Integer quantity) {
//        OrderItem newOrderItem = OrderItem.builder()
//
//                .build();
//    }

}
