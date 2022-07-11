package com.example.demo.order.service.impl;


import com.example.demo.order.jpa.Order;
import com.example.demo.order.repository.OrderRepository;
import com.example.demo.order.service.OrderService;
import com.example.demo.user.jpa.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public Order getById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public List<Order> getByMainUser(String account) {
        // User
        User user = new User();
        user.setAccount(account);
        // order
        Order order = new Order();
        order.setMainUser(user);
        // Example
        Example<Order> example = Example.of(order);
        // get and return
        return orderRepository.findAll(example);
    }

    @Override
    public void insert(Order order) {
        orderRepository.save(order);
    }

    @Override
    public void update(Order order) {
        orderRepository.save(order);
    }

    @Override
    public void delete(Long id) {
        orderRepository.deleteById(id);
    }


}
