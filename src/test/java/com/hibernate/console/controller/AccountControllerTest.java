package com.hibernate.console.controller;

import com.hibernate.console.model.Account;
import com.hibernate.console.model.AccountStatus;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountControllerTest {
    private AccountController accountController = new AccountController();
    private Account account;

    @BeforeEach
    void setUp() {
        account = new Account(AccountStatus.ACTIVE);
        accountController.saveAccount(account);
    }

    @AfterEach
    void tearDown() {
        accountController.deleteAccount(account.getId());
    }

    @Test
    void printAllTest() {
        assertTrue(accountController.printAll().size() > 0);
    }

    @Test
    void saveAccountTest() {
        assertEquals(account, accountController.getValueByIndex(account.getId()));
    }

    @Test
    void deleteAccountTest() {
        Account accountDelete = new Account(AccountStatus.ACTIVE);
        accountController.saveAccount(accountDelete);
        accountController.deleteAccount(accountDelete.getId());
        assertNull(accountController.getValueByIndex(accountDelete.getId()), "Account should be null");
    }

    @Test
    void updateAccountTest() {
        account.setStatus(AccountStatus.BANNED);
        accountController.updateAccount(account.getId(), account);
        String updateStatus = accountController.getValueByIndex(account.getId()).getStatus().name();
        assertEquals("BANNED", updateStatus);
    }

    @Test
    void getValueByIndexTest() {
        assertNotNull(accountController.getValueByIndex(account.getId()));
    }
}