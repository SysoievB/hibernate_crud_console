package com.hibernate.console.view;

import com.hibernate.console.controller.OrderController;
import com.hibernate.console.model.Order;

import java.util.Scanner;

public class OrderView {
    private Scanner scanner = new Scanner(System.in);
    private OrderController controller = new OrderController();

    public void printOrders() {
        System.out.println("List of all orders: ");
        controller.printAll().forEach(System.out::println);
    }

    public void deleteOrder() {
        System.out.println("Enter id in order to delete row: ");
        Long index = Long.parseLong(scanner.next());
        controller.deleteOrder(index);
    }

    public void getByIdOrder() {
        System.out.println("Enter id in order to get order:");
        Long id = Long.parseLong(scanner.next());
        try {
            if (controller.getValueByIndex(id) != null)
                System.out.println(controller.getValueByIndex(id).toString());

        } catch (NullPointerException e) {
            System.out.println("There is no such number ");
            System.out.println("Try one more time, please");
            getByIdOrder();
        }
    }

    public void saveOrder() {
        System.out.println("Enter id: ");
        Long id = Long.parseLong(scanner.next());
        System.out.println("Enter order: ");
        String orderName = scanner.next();
        Order newOrder = new Order(id, orderName);
        controller.saveOrder(newOrder);
    }

    public void updateOrder() {
        System.out.println("Enter id in order to find element:");
        Long id = Long.parseLong(scanner.next());
        System.out.println("Enter new order: ");
        String orderName = scanner.next();
        Order newOrder = new Order(id, orderName);
        controller.updateOrder(id, newOrder);
    }

    public void run() {
        boolean go = true;
        while (go) {
            System.out.println("\nChoose option, please:" +
                    "\nEnter number:" +
                    "\n1. Show all rows" +
                    "\n2. Insert new row" +
                    "\n3. Delete row" +
                    "\n4. Update row" +
                    "\n5. Search by id" +
                    "\n6. End");
            int number = scanner.nextInt();
            switch (number) {
                case 1:
                    printOrders();
                    break;
                case 2:
                    saveOrder();
                    break;
                case 3:
                    deleteOrder();
                    break;
                case 4:
                    updateOrder();
                    break;
                case 5:
                    getByIdOrder();
                    break;
                case 6:
                    go = false;
                    break;
                default:
                    System.out.println("Wrong number " +
                            "\nEnter number from 1 to 6, please");
            }
        }
    }
}
