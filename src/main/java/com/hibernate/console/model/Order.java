package com.hibernate.console.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
@Data
public class Order extends BaseEntity {
    @Column(name = "order_name")
    private String orderName;

    public Order() {
    }

    public Order(Long id, String orderName) {
        this.id = id;
        this.orderName = orderName;
    }

    @Override
    public String toString() {
        return id + " " + orderName;
    }
}
