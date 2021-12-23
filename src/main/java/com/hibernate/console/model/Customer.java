package com.hibernate.console.model;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "customers")
@Data
public class Customer extends BaseEntity {
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    private Account account;
    @JoinTable(name = "customers_orders",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "order_id"))
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Order> orders = new HashSet<>();

    public Customer() {
    }

    public Customer(String name, String surname, Account account, Set<Order> orders) {
        this.name = name;
        this.surname = surname;
        this.account = account;
        this.orders = orders;
    }

    public Customer(Long id, String name, String surname, Account account, Set<Order> orders) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.account = account;
        this.orders = orders;
    }

    public Set<Long> ordersToString() {

        return orders
                .stream()
                .map(Order::getId)
                .collect(Collectors.toSet());
    }

    @Override
    public String toString() {
        return id + " " + name + " " + surname + " " + account.getId() + " " + ordersToString();
    }
}
