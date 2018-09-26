package com.epamsystems;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {

    private List<Account> accounts = new ArrayList<>();

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public void addAccount() {
        Customer customer = getCustomer();
        Currency currency = getCurrency();
        BigDecimal initialBalance = getInitialBalance();
        Account account = new Account(accounts.size() + 1, initialBalance, currency, customer);
        accounts.add(account);
        System.out.println("Account added: \n" + account.toString() + "\n");
    }

    private static BigDecimal getInitialBalance() {
        Scanner getInput = new Scanner(System.in);
        System.out.print("Enter initial balance: ");
        return BigDecimal.valueOf(Long.parseLong(getInput.next()));
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

    public void showAccount() {
        Scanner getInput = new Scanner(System.in);
        System.out.print("Enter account number: ");
        int accountNumber = getInput.nextInt();
        System.out.println(accounts.stream().filter(a -> a.getAccountNumber() == accountNumber).findAny().get().toString());
        System.out.println();
    }

    public void listAccounts() {
        System.out.println("Accounts:\n");
        accounts.stream().forEach(a -> System.out.println(a.toString() + "\n"));
    }
}
