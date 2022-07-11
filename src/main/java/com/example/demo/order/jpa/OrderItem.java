package com.example.demo.order.jpa;


import com.example.demo.store.jpa.MenuItem;
import com.example.demo.user.jpa.User;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;


/**
 * 訂單細項(餐點)
 */
@Entity
public class OrderItem {

    /**
     * id
     */
    @Id
    private Long id;

    /**
     * 訂單
     */
    @ManyToOne
    private Order order;

    /**
     * 訂購者
     */
    @ManyToOne
    private User user;

    /**
     * 訂購品項
     */
    @ManyToOne
    private MenuItem menuItem;

    /**
     * 訂購數量
     */
    private int quantity;

    /**
     * 訂購日期
     */
    private Date createData;

    /**
     * 備註
     */
    private String memo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getCreateData() {
        return createData;
    }

    public void setCreateData(Date createData) {
        this.createData = createData;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}
