package com.hibernate.console.controller;

import com.hibernate.console.model.Account;
import com.hibernate.console.model.AccountStatus;
import com.hibernate.console.model.Customer;
import com.hibernate.console.model.Order;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CustomerControllerTest {
    private CustomerController customerController = new CustomerController();
    private AccountController accountController = new AccountController();
    private OrderController orderController = new OrderController();
    private Customer customer;
    private Account account;
    private Order order;

    @BeforeEach
    void setUp() {
        account = new Account(AccountStatus.ACTIVE);
        accountController.saveAccount(account);

        order = new Order("test_order");
        orderController.saveOrder(order);

        Set<Order> orders = new HashSet<>(Arrays.asList(order));
        customer = new Customer("test_name", "test_surname", account, orders);
        customerController.saveCustomer(customer);
    }

    @AfterEach
    void tearDown() {
        customerController.deleteCustomer(customer.getId());
    }

    @Test
    void printAllTest() {
        assertTrue(customerController.printAll().size() > 0);
    }

    @Test
    void saveCustomerTest() {
        assertEquals(customer, customerController.getValueByIndex(customer.getId()));
    }

    @Test
    void deleteCustomerTest() {
        Account account = new Account(AccountStatus.ACTIVE);
        accountController.saveAccount(account);

        Order order = new Order("test_order");
        orderController.saveOrder(order);

        Set<Order> orders = new HashSet<>(Arrays.asList(order));
        Customer customer = new Customer("test_name", "test_surname", account, orders);
        customerController.saveCustomer(customer);

        customerController.deleteCustomer(customer.getId());

        assertNull(orderController.getValueByIndex(customer.getId()), "Customer should be null");
    }

    @Test
    void updateCustomerTest() {
        customer.setName("new_test");

        customer.setSurname("new_test");

        Order order = new Order("new_test_order");
        orderController.saveOrder(order);
        Set<Order> orders = new HashSet<>(Arrays.asList(order));
        customer.setOrders(orders);

        customer.setAccount(new Account(AccountStatus.BANNED));

        customerController.updateCustomer(customer.getId(), customer);

        String updateName = customerController.getValueByIndex(customer.getId()).getName();
        assertEquals("new_test", updateName);
    }

    @Test
    void getValueByIndexTest() {
        assertNotNull(customerController.getValueByIndex(customer.getId()));
    }
}