package com.epamsystems.DAO;

import com.epamsystems.Service.CSVUtil;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddAccount extends Command {
    @Override
    public void executeCommand(String args) {
        List<Account> accounts = new ArrayList<>();
        try {
            accounts = Account.getAccounts(CSVUtil.readCSV());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Customer customer = getCustomer();
        Currency currency = getCurrency();
        BigDecimal initialBalance = getInitialBalance();
        Account account = new Account(getAccountNumber() + 1, initialBalance, currency, customer);
        accounts.add(account);
        CSVUtil.writeCSV(accounts);
        System.out.println("Account added: \n" + account.toString() + "\n");
    }

    private static int getAccountNumber() {
        try {
            return CSVUtil.readCSV().size();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 1;
    }

    private static BigDecimal getInitialBalance() {
        Scanner getInput = new Scanner(System.in);
        System.out.print("Enter initial balance: ");
        return BigDecimal.valueOf(Double.parseDouble(getInput.next()));
    }

    private static Currency getCurrency() {
        Scanner getInput = new Scanner(System.in);
        System.out.print("Enter account currency: ");
        return Currency.valueOf(getInput.next().toUpperCase());
    }

    private static Customer getCustomer() {
        Scanner getInput = new Scanner(System.in);
        System.out.print("Enter customer name: ");
        String name = getInput.next();
        System.out.print("Enter customer surname: ");
        String surName = getInput.next();
        return new Customer(name, surName);
    }
}
