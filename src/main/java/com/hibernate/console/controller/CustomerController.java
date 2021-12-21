package com.hibernate.console.controller;

import com.hibernate.console.model.Customer;
import com.hibernate.console.repository.CustomerRepository;
import com.hibernate.console.repository.impl.CustomerRepositoryImpl;

import java.util.List;

public class CustomerController {
    private CustomerRepository repository = new CustomerRepositoryImpl();

    public List<Customer> printAll() {

        return repository.getAll();
    }

    public void saveCustomer(Customer newCustomer) {
        repository.add(newCustomer);
    }

    public void deleteCustomer(Long index) {
        repository.deleteById(index);
    }

    public void updateCustomer(Long id, Customer updateCustomer) {
        repository.update(id, updateCustomer);
    }

    public Customer getValueByIndex(Long index) {

        return repository.getById(index);
    }
}