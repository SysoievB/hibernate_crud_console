package com.hibernate.console.view;

import com.hibernate.console.controller.AccountController;
import com.hibernate.console.model.Account;
import com.hibernate.console.model.AccountStatus;

import java.util.Scanner;

public class AccountView {
    private Scanner scanner = new Scanner(System.in);
    private AccountController accountController = new AccountController();


    public void printAccounts() {
        System.out.println("List of all accounts:");
        System.out.println(accountController.printAll());
    }

    public void deleteAccount() {
        System.out.println("Enter id in order to delete row:");
        Long index = Long.parseLong(scanner.next());
        accountController.deleteAccount(index);
    }

    public void getByIdAccount() {
        System.out.println("Enter id in order to get account:");
        Long id = Long.parseLong(scanner.next());
        try {
            if (accountController.getValueByIndex(id) != null)
                System.out.println(accountController.getValueByIndex(id).toString());

        } catch (NullPointerException e) {
            System.out.println("There is no such number \n" +
                    "Try one more time, please");
            getByIdAccount();
        }
    }

    public void saveAccount() {
        System.out.println("Enter id:");
        Long id = Long.parseLong(scanner.next());
        Account newAccount = new Account(id, AccountStatus.ACTIVE);
        accountController.saveAccount(newAccount);
    }

    public void updateAccount() {
        System.out.println("Enter id in order to find element:");
        Long id = Long.parseLong(scanner.next());
        System.out.println("Enter status: 1.ACTIVE, 2.DELETED or 3.BANNED");
        String accountStatusStr = scanner.next();
        AccountStatus accountStatusVar = null;
        switch (accountStatusStr) {
            case "1":
                accountStatusVar = AccountStatus.ACTIVE;
                break;
            case "2":
                accountStatusVar = AccountStatus.DELETED;
                break;
            case "3":
                accountStatusVar = AccountStatus.BANNED;
                break;
        }
        Account newAccount = new Account(id, accountStatusVar);
        accountController.updateAccount(id, newAccount);
    }

    public void run() {
        boolean go = true;
        while (go) {
            var variants = "\nChoose option, please:\nEnter number:\n1. Show all rows\n2. Insert new row\n3. Delete row\n4. Update row\n5. Search by id\n6. End";
            variants.lines().forEach(System.out::println);
            int number = scanner.nextInt();
            switch (number) {
                case 1:
                    printAccounts();
                    break;
                case 2:
                    saveAccount();
                    break;
                case 3:
                    deleteAccount();
                    break;
                case 4:
                    updateAccount();
                    break;
                case 5:
                    getByIdAccount();
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