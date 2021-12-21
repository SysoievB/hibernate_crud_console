package com.hibernate.console.repository.impl;

import com.hibernate.console.model.Account;
import com.hibernate.console.repository.AccountRepository;
import com.hibernate.console.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AccountRepositoryImpl implements AccountRepository {
    private Session session;
    private Transaction transaction;

    @Override
    public void add(Account account) {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.save(account);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Account> getAll() {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        List<Account> accounts = session.createQuery("from Account", Account.class).getResultList();
        transaction.commit();
        session.close();

        return accounts;
    }

    @Override
    public Account getById(Long id) {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        Account account = session.get(Account.class, id);
        transaction.commit();
        session.close();

        return account;
    }

    @Override
    public void update(Long id, Account account) {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.saveOrUpdate(account);
        transaction.commit();
        session.close();
    }

    @Override
    public void deleteById(Long id) {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        Account account = session.get(Account.class, id);
        session.remove(account);
        transaction.commit();
        session.close();
    }
}
