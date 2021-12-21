package com.hibernate.console.repository.impl;

import com.hibernate.console.model.Order;
import com.hibernate.console.repository.OrderRepository;
import com.hibernate.console.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class OrderRepositoryImpl implements OrderRepository {
    private Session session = HibernateUtil.getSessionFactory().openSession();
    private Transaction transaction = session.beginTransaction();

    @Override
    public void save(Order order) {
        session.save(order);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Order> getAll() {
        List<Order> orders = session.createQuery("from orders").getResultList();
        transaction.commit();
        session.close();

        return orders;
    }

    @Override
    public Order getById(Long id) {
        Order order = session.get(Order.class, id);
        transaction.commit();
        session.close();

        return order;
    }

    @Override
    public void update(Long id, Order order) {
        session.saveOrUpdate(order);
        transaction.commit();
        session.close();
    }

    @Override
    public void deleteById(Long id) {
        Order order = session.get(Order.class, id);
        session.remove(order);
        transaction.commit();
        session.close();
    }
}
