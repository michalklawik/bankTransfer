package com.epamsystems.DAO;

import com.epamsystems.Service.CSVUtil;

import java.io.IOException;
import java.util.List;

public class ListAccounts extends Command {
    @Override
    public void executeCommand(String arg) {
        List<Account> accounts = null;
        try {
            accounts = Account.getAccounts(CSVUtil.readCSV());
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (accounts.isEmpty()) {
            System.out.println("No accounts loaded!");
        } else {
            System.out.println("Accounts:\n");
            accounts.stream().forEach(a -> System.out.println(a.toString() + "\n"));
        }
    }
}
