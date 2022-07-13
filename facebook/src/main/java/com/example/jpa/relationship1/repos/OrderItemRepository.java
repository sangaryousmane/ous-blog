package com.example.jpa.relationship1.repos;

import com.example.jpa.relationship1.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}