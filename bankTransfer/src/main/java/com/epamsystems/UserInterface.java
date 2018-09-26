package com.epamsystems;

import java.util.Scanner;

public class UserInterface {

    User user = new User();

    public static void printMainMenu() {
        System.out.println("Please choose an option:");
        System.out.println("1. Add account.");
        System.out.println("2. Show Account.");
        System.out.println("3. List accounts.");
    }

    public void getUsersChoice() {
        while (true) {
            System.out.print("Enter selection: ");
            Scanner getChoice = new Scanner(System.in);
            String choice = getChoice.next();
            switch (choice.toLowerCase()) {
                case "1":
                    user.addAccount();
                    printMainMenu();
                    break;
                case "addaccount":
                    user.addAccount();
                    printMainMenu();
                    break;
                case "2":
                    user.showAccount();
                    printMainMenu();
                    break;
                case "showaccount":
                    user.showAccount();
                    printMainMenu();
                    break;
                case "3":
                    System.out.println("Third option chosen");
                    printMainMenu();
                    break;
                case "listaccounts":
                    System.out.println("Third option chosen");
                    printMainMenu();
                    break;
                case "exit":
                    System.exit(0);
                default:
                    System.out.println("Unknown command\n");
            }
        }
    }


}
