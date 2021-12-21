package com.hibernate.console.repository.impl;

import com.hibernate.console.model.Customer;
import com.hibernate.console.repository.CustomerRepository;
import com.hibernate.console.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository {
    private Session session;
    private Transaction transaction;

    @Override
    public void add(Customer customer) {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.save(customer);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Customer> getAll() {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        List<Customer> customers = session.createQuery("from Customer", Customer.class).getResultList();
        transaction.commit();
        session.close();

        return customers;
    }

    @Override
    public Customer getById(Long id) {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        Customer customer = session.get(Customer.class, id);
        transaction.commit();
        session.close();

        return customer;
    }

    @Override
    public void update(Long id, Customer customer) {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.saveOrUpdate(customer);
        transaction.commit();
        session.close();
    }

    @Override
    public void deleteById(Long id) {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        Customer customer = session.get(Customer.class, id);
        session.remove(customer);
        transaction.commit();
        session.close();
    }
}
