package com.example.demo.order.controller;

import com.example.demo.order.jpa.Order;
import com.example.demo.order.service.OrderService;
import com.example.demo.utils.MessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    /*
     * 取得資料 by id
     * url: http://localhost:8080/order/1
     * method: get
     */
    @GetMapping("/{id}")
    public Map<String, Object> get(@PathVariable("id") Long id) {
        try{
            // get order
            Order order = orderService.getById(id);
            // 成功
            return MessageUtils.success(order);
        } catch (Exception e){
            // 失敗
            return MessageUtils.error(e.getMessage());
        }
    }

    /*
     * 取得資料 by 主揪人帳號 mainUser.account
     * url: http://localhost:8080/order/getByMainUser/AA
     * method: get
     */
    @GetMapping("/getByMainUser/{account}")
    public Map<String, Object> getByMainUser(@PathVariable("account") String account) {
        try{
            // get order
            List<Order> data = orderService.getByMainUser(account);
            // 成功
            return MessageUtils.success(data);
        } catch (Exception e){
            // 失敗
            return MessageUtils.error(e.getMessage());
        }
    }

    /*
     * 新增資料
     * url: http://localhost:8080/order/
     * method: post
     * data:
     * <pre>
        {
            "id": 1,
            "status": 0,
            "createData": "2022-07-11T20:11:22",
            "mainUser":{
                "account": "AA"
            }
        }
     * </pre>
     */
    @PostMapping
    public Map<String, Object> insert(@RequestBody Order order) {
        try{
            // 新增
            orderService.insert(order);
            // 成功
            return MessageUtils.success();
        } catch (Exception e){
            // 失敗
            return MessageUtils.error(e.getMessage());
        }
    }

    /*
     * 修改資料
     * url: http://localhost:8080/order/
     * method: put
     * data: 與新增相同
     */
    @PutMapping
    public Map<String, Object> update(@RequestBody Order order) {
        try{
            // 修改
            orderService.update(order);
            // 成功
            return MessageUtils.success();
        } catch (Exception e){
            // 失敗
            return MessageUtils.error(e.getMessage());
        }

    }

    /*
     * 刪除資料 by id
     * url: http://localhost:8080/order/1
     * method: delete
     */
    @DeleteMapping("/{id}")
    public Map<String, Object> delete(@PathVariable("id") Long id) {
        try{
            // 刪除
            orderService.delete(id);
            // 成功
            return MessageUtils.success();
        } catch (Exception e){
            // 失敗
            return MessageUtils.error(e.getMessage());
        }
    }

}
