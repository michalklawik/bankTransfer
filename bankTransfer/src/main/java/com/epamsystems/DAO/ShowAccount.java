package com.epamsystems.DAO;

import com.epamsystems.Service.CSVUtil;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

public class ShowAccount extends Command {
    @Override
    public void executeCommand(String args) {
        int accountNumber = Integer.valueOf(args.split(" ")[1]);
        List<Account> accounts = null;
        try {
            accounts = Account.getAccounts(CSVUtil.readCSV());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(accounts.stream()
                    .filter(a -> a.getAccountNumber() == accountNumber)
                    .findAny()
                    .get()
                    .toString());
        } catch (NoSuchElementException e) {
            System.out.println("Account not found");
        }
        System.out.println();
    }
}
