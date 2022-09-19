package com.example.bookstoreonline.service.impl;

import com.example.bookstoreonline.model.*;
import com.example.bookstoreonline.repository.*;
import com.example.bookstoreonline.service.IOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

@Service
@Slf4j
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Override
    public Order checkout(User user, String receiverName, String receiverAddress, String receiverPhone) {
        ShoppingCart shoppingCart = shoppingCartRepository.getShoppingCartByUser(user);
        Set<CartItem> cartItemSet = shoppingCart.getCartItem();
        Set<OrderItem> orderItemSet = new HashSet<>();
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        Order order = Order.builder()
                .orderDate(LocalDateTime.parse(formatter.format(now), formatter))
                .user(user)
                .receiverName(receiverName)
                .receiverAddress(receiverAddress)
                .receiverPhone(receiverPhone)
                .totalAmount(shoppingCart.getTotalPrices())
                .build();
        Order newOrder = orderRepository.save(order);
        cartItemSet.forEach(cartItem -> {
            OrderItem orderItem = OrderItem.builder()
                    .book(cartItem.getBook())
                    .quantity(cartItem.getQuantity())
                    .totalPrice(cartItem.getTotalPrice())
                    .order(newOrder)
                    .build();
            orderItemSet.add(orderItem);
            Book book = bookRepository.getById(cartItem.getBook().getId());
            book.setQuantity(book.getQuantity() - cartItem.getQuantity());
            bookRepository.save(book);
        });
        newOrder.setOrderItem(orderItemSet);
        return orderRepository.save(newOrder);
    }
}
