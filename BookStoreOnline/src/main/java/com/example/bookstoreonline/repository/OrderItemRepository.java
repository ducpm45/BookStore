package com.example.bookstoreonline.repository;

import com.example.bookstoreonline.model.OrderItem;
import com.example.bookstoreonline.service.impl.OrderItemServiceImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
