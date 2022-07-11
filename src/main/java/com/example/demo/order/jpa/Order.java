package com.example.demo.order.jpa;



import com.example.demo.store.jpa.Store;
import com.example.demo.user.jpa.User;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * 訂單
 */
@Entity(name = "_order")
public class Order {

    /**
     * id
     */
    @Id
    private Long id;

    /**
     * 訂單發起人
     */
    @ManyToOne
    private User mainUser;

    /**
     * 其他參與訂單的人
     */
    @ManyToMany
    private List<User> subUser;

    /**
     * 開團店家
     */
    @ManyToOne
    private Store store;

    /**
     * 團購細項
     */
    @OneToMany
    private List<OrderItem> orderItem;

    /**
     * 狀態
     */
    public enum Status {
        start, // 已開團
        cancel, // 取消成團
        confirm, // 確定成團
        complete, // 團購完成
    }
    private Status status;

    /**
     * 狀態描述
     */
    private String statusDescribe;

    /**
     * 開團日期
     */
    private Date createData;

    /**
     * 成團日期
     */
    private Date confirmData;

    /**
     * 取消日期
     */
    private Date cancelData;

    /**
     * 完成日期
     */
    private Date completeData;

    public Order() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getMainUser() {
        return mainUser;
    }

    public void setMainUser(User mainUser) {
        this.mainUser = mainUser;
    }

    public List<User> getSubUser() {
        return subUser;
    }

    public void setSubUser(List<User> subUser) {
        this.subUser = subUser;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public List<OrderItem> getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(List<OrderItem> orderItem) {
        this.orderItem = orderItem;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getStatusDescribe() {
        return statusDescribe;
    }

    public void setStatusDescribe(String statusDescribe) {
        this.statusDescribe = statusDescribe;
    }

    public Date getCreateData() {
        return createData;
    }

    public void setCreateData(Date createData) {
        this.createData = createData;
    }

    public Date getConfirmData() {
        return confirmData;
    }

    public void setConfirmData(Date confirmData) {
        this.confirmData = confirmData;
    }

    public Date getCancelData() {
        return cancelData;
    }

    public void setCancelData(Date cancelData) {
        this.cancelData = cancelData;
    }

    public Date getCompleteData() {
        return completeData;
    }

    public void setCompleteData(Date completeData) {
        this.completeData = completeData;
    }
}
