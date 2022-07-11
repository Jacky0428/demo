package com.example.demo.order.service;

import com.example.demo.order.jpa.Order;

import java.util.List;

public interface OrderService {
    /**
     * 取得訂單 by id
     */
    Order getById(Long id);

    /**
     * 取得訂單 by 主揪人帳號 MainUser
     */
    List<Order> getByMainUser(String account);

    /**
     * 新增訂單
     */
    void insert(Order order);

    /**
     * 修改訂單
     */
    void update(Order order);

    /**
     * 刪除訂單
     */
    void delete(Long id);

}
