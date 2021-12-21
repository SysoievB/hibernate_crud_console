package com.hibernate.console.view;

import java.util.Scanner;

public class CommonView {

    private OrderView orderView;
    private static CommonView view;

    private CommonView() {
        orderView = new OrderView();
    }

    public static CommonView getInstance() {
        if (view == null) {
            view = new CommonView();
        }
        return view;
    }


    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean go = true;
        while (go) {
            System.out.println("\nChoose file in order to do operations, please:" +
                    "\nEnter number:" +
                    "\n1.Orders" +
                    "\n2.Accounts" +
                    "\n3.Customers" +
                    "\n4.Exit");
            int number = scanner.nextInt();
            switch (number) {
                case 1:
                    runOrder();
                    break;
                case 4:
                    go = false;
                    break;
                default:
                    System.out.println("Wrong number" +
                            "\nEnter number from 1 to 4, please");
            }
        }
    }

    public void runOrder() {
        orderView.run();
    }
}