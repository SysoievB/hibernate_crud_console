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

    @Override
    public String toString() {
        return id + " " + orderName;
    }
}
