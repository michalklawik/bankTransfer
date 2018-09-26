package com.epamsystems;

public class UserInterface {

    User user = new User();

    public static void printMainMenu() {
        System.out.println("Please choose an option:");
        System.out.println("1. Add account.");
        System.out.println("2. Show Account.");
        System.out.println("3. List accounts.");
    }

    public void getUsersChoice(String choice) {
        while (true) {
            switch (choice.toLowerCase()) {
                case "1":
                    user.addAccount();
                    break;
                case "addaccount":
                    user.addAccount();
                    break;
                case "2":
                    System.out.println("Second option chosen");
                    break;
                case "showaccount":
                    System.out.println("Second option chosen");
                    break;
                case "3":
                    System.out.println("Third option chosen");
                    break;
                case "listaccounts":
                    System.out.println("Third option chosen");
                    break;
                case "exit":
                    System.exit(0);
                default:
                    System.out.println("Unknown command\n");
            }
        }
    }


}
