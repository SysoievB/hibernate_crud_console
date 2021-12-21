package com.hibernate.console.repository.impl;

import com.hibernate.console.model.Order;
import com.hibernate.console.repository.OrderRepository;
import com.hibernate.console.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class OrderRepositoryImpl implements OrderRepository {
    private Session session;
    private Transaction transaction;

    @Override
    public void save(Order order) {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.save(order);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Order> getAll() {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        List<Order> orders = (List<Order>) session.createQuery("from Order", Order.class).getResultList();
        transaction.commit();
        session.close();

        return orders;
    }

    @Override
    public Order getById(Long id) {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        Order order = session.get(Order.class, id);
        transaction.commit();
        session.close();

        return order;
    }

    @Override
    public void update(Long id, Order order) {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.saveOrUpdate(order);
        transaction.commit();
        session.close();
    }

    @Override
    public void deleteById(Long id) {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        Order order = session.get(Order.class, id);
        session.remove(order);
        transaction.commit();
        session.close();
    }
}
