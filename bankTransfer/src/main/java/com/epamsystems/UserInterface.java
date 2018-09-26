package com.epamsystems;

public class UserInterface {

    public static void printMainMenu() {
        System.out.println("Please choose an option:");
        System.out.println("1. Add account.");
        System.out.println("2. Show Account.");
        System.out.println("3. List accounts.");
    }

    public static void getUsersChoice(String choice) {
        switch (choice.toLowerCase()) {
            case "1":
                System.out.println("First option chosen");
                break;
            case "add account":
                System.out.println("First option chosen");
                break;
            case "2":
                System.out.println("Second option chosen");
                break;
            case "show account":
                System.out.println("Second option chosen");
                break;
            case "3":
                System.out.println("Third option chosen");
                break;
            case "list accounts":
                System.out.println("Third option chosen");
                break;
            case "exit":
                System.exit(0);
            default:
                System.out.println("Unknown command");
        }
    }
}
