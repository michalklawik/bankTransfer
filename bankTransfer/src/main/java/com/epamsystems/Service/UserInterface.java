package com.epamsystems.Service;

import com.epamsystems.DAO.*;

import java.math.BigDecimal;
import java.util.Scanner;

public class UserInterface {

    User user = new User();

    public static void printInputLine() {
        System.out.print("Transfer> ");
    }

    public void getUsersChoice() {
        Scanner getInput = new Scanner(System.in);
        String input = getInput.nextLine();
        String[] splitInput = input.split(" ");
        System.out.println();
        switch (splitInput[0]) {
            case "addaccount":
                new AddAccount().executeCommand(input);
                printInputLine();
                getUsersChoice();
                break;
            case "showaccount":
                new ShowAccount().executeCommand(input);
                printInputLine();
                getUsersChoice();
                break;
            case "listaccounts":
                new ListAccounts().executeCommand(input);
                printInputLine();
                getUsersChoice();
                break;
            case "transfer":
                user.transferMoney(Integer.valueOf(splitInput[1]), Integer.valueOf(splitInput[2]), BigDecimal.valueOf(Double.parseDouble(splitInput[3])));
                printInputLine();
                getUsersChoice();
                break;
            case "exit":
                System.exit(0);
            default:
                System.out.println("Unknown command\n");
                printInputLine();
                getUsersChoice();
                break;
        }
    }


}
