package com.hibernate.console.model;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "customers")
@Data
public class Customer extends BaseEntity {
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @JoinColumn(name = "account_id")
    @OneToOne(cascade = {CascadeType.ALL})
    private Account account;
    @Column(name = "order_id")
    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private Set<Order> orders = new HashSet<>();

    public Customer() {
    }

    public Customer(Long id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public Customer(Long id, String name, String surname, Account account, Set<Order> orders) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.account = account;
        this.orders = orders;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + surname + " " + account.getId() + " " + orders;
    }
}
