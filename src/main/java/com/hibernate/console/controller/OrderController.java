package com.hibernate.console.controller;

import com.hibernate.console.model.Order;
import com.hibernate.console.repository.OrderRepository;
import com.hibernate.console.repository.impl.OrderRepositoryImpl;

import java.util.List;

public class OrderController {
    private OrderRepository orderRepository = new OrderRepositoryImpl();

    public List<Order> printAll() {

        return orderRepository.getAll();
    }

    public void saveOrder(Order newOrder) {
        orderRepository.add(newOrder);
    }

    public void deleteOrder(Long index) {
        orderRepository.deleteById(index);
    }

    public void updateOrder(Long id, Order updateOrder) {
        orderRepository.update(id, updateOrder);
    }

    public Order getValueByIndex(Long index) {
        return orderRepository.getById(index);
    }
}
