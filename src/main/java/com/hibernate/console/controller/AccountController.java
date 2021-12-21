package com.hibernate.console.controller;

import com.hibernate.console.model.Account;
import com.hibernate.console.repository.AccountRepository;
import com.hibernate.console.repository.impl.AccountRepositoryImpl;

import java.util.List;

public class AccountController {
    private AccountRepository repository = new AccountRepositoryImpl();

    public List<Account> printAll() {
        return repository.getAll();
    }

    public void saveAccount(Account newAccount) {
        repository.add(newAccount);
    }

    public void deleteAccount(Long index) {
        repository.deleteById(index);
    }

    public void updateAccount(Long id, Account updateAccount) {
        repository.update(id, updateAccount);
    }

    public Account getValueByIndex(Long index) {
        return repository.getById(index);
    }
}
