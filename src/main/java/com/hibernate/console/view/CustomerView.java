package com.hibernate.console.view;

import com.hibernate.console.controller.CustomerController;
import com.hibernate.console.model.Account;
import com.hibernate.console.model.Customer;
import com.hibernate.console.model.Order;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CustomerView {
    private Scanner scanner = new Scanner(System.in);
    private CustomerController customerController = new CustomerController();

    public void printCustomers() {
        System.out.println("List of all customers:");
        System.out.println(customerController.printAll());
    }

    public void deleteCustomer() {
        System.out.println("Enter id in order to delete row:");
        Long index = Long.parseLong(scanner.next());
        customerController.deleteCustomer(index);
    }

    public void getByIdCustomer() {
        System.out.println("Enter id in order to get customer:");
        Long id = Long.parseLong(scanner.next());
        try {
            if (customerController.getValueByIndex(id) != null)
                System.out.println(customerController.getValueByIndex(id).toString());

        } catch (NullPointerException e) {
            System.out.println("There is no such number " +
                    "\nTry one more time, please");
            getByIdCustomer();
        }
    }

    public void saveCustomer() {
        System.out.println("Enter id:");
        Long id = Long.parseLong(scanner.next());
        System.out.println("Enter name:");
        String name = scanner.next();
        System.out.println("Enter surname:");
        String surname = scanner.next();
        System.out.println("Enter id of account:");
        Long idAccount = Long.parseLong(scanner.next());
        Account account = new Account(idAccount);
        Set<Order> orderSet = new HashSet<>();
        System.out.println("Enter id of order:");
        Long idOrder = Long.parseLong(scanner.next());
        orderSet.add(new Order(idOrder));
        boolean go = true;
        while (go) {
            System.out.println("Do You want to add one more id of order? 1.Yes 2.No");
            String yesOrNo = scanner.next();
            switch (yesOrNo) {
                case ("1"):
                    System.out.println("Enter id of new order:");
                    Long newIdOrder = Long.parseLong(scanner.next());
                    orderSet.add(new Order(newIdOrder));
                    break;
                case ("2"):
                    System.out.println("You choose do not add new order");
                    go = false;
                    break;
            }
        }
        Customer newCustomer = new Customer(id, name, surname, account, orderSet);
        customerController.saveCustomer(newCustomer);
    }


    public void updateCustomer() {
        Customer newCustomer;
        System.out.println("Enter id in order to find element:");
        Long id = Long.parseLong(scanner.next());
        System.out.println("Enter name:");
        String name = scanner.next();
        System.out.println("Enter surname:");
        String surname = scanner.next();
        newCustomer = new Customer(id, name, surname);
        customerController.updateCustomer(id, newCustomer);
    }

    public void run() {
        boolean go = true;
        while (go) {
            var variants = "\nChoose option, please:\nEnter number:\n1. Show all rows\n2. Insert new row\n3. Delete row\n4. Update row\n5. Search by id\n6. End";
            variants.lines().forEach(System.out::println);
            int number = scanner.nextInt();
            switch (number) {
                case 1:
                    printCustomers();
                    break;
                case 2:
                    saveCustomer();
                    break;
                case 3:
                    deleteCustomer();
                    break;
                case 4:
                    updateCustomer();
                    break;
                case 5:
                    getByIdCustomer();
                    break;
                case 6:
                    go = false;
                    break;
                default:
                    System.out.println("Wrong number" +
                            "\nEnter number from 1 to 6, please");
            }
        }
    }
}
