package com.epamsystems.Service;

import com.epamsystems.DAO.User;

import java.math.BigDecimal;
import java.util.Scanner;

public class UserInterface {

    User user = new User();

    public static void printInputLine() {
        System.out.print("Transfer> ");
    }

    public void getUsersChoice() {
        while (true) {
            Scanner getInput = new Scanner(System.in);
            String input = getInput.nextLine();
            String[] splitInput = input.split(" ");
            System.out.println();
            switch (splitInput[0]) {
                case "addaccount":
                    user.addAccount();
                    printInputLine();
                    break;
                case "showaccount":
                    user.showAccount(Integer.parseInt(splitInput[1]));
                    printInputLine();
                    break;
                case "listaccounts":
                    user.listAccounts();
                    printInputLine();
                    break;
                case "transfer":
                    user.transferMoney(Integer.valueOf(splitInput[1]), Integer.valueOf(splitInput[2]), BigDecimal.valueOf(Double.parseDouble(splitInput[3])));
                    printInputLine();
                    break;
                case "exit":
                    System.exit(0);
                default:
                    System.out.println("Unknown command\n");
                    printInputLine();
                    break;
            }
        }
    }


}
