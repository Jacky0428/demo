package com.example.demo.order.repository;

import com.example.demo.order.jpa.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
