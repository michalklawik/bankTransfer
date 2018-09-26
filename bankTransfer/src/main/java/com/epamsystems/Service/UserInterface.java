package com.epamsystems.Service;

import com.epamsystems.DAO.User;

import java.util.Scanner;

public class UserInterface {

    User user = new User();

    public static void printInputLine() {
        System.out.print("Transfer> ");
    }

    public void getUsersChoice() {
        while (true) {
            Scanner getChoice = new Scanner(System.in);
            String choice = getChoice.next();
            System.out.println();
            switch (choice.toLowerCase()) {
                case "1":
                    user.addAccount();
                    printInputLine();
                    break;
                case "addaccount":
                    user.addAccount();
                    printInputLine();
                    break;
                case "2":
                    user.showAccount();
                    printInputLine();
                    break;
                case "showaccount":
                    user.showAccount();
                    printInputLine();
                    break;
                case "3":
                    user.listAccounts();
                    printInputLine();
                    break;
                case "listaccounts":
                    user.listAccounts();
                    printInputLine();
                    break;
                case "exit":
                    System.exit(0);
                default:
                    System.out.println("Unknown command\n");
            }
        }
    }


}
