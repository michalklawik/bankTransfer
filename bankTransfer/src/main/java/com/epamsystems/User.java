package com.epamsystems;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
        System.out.println("Account added: \n" + account.toString());
    }

    private static BigDecimal getInitialBalance() {
        Scanner getInput = new Scanner(System.in);
        System.out.print("Enter initial balance: ");
        return BigDecimal.valueOf(Long.parseLong(Optional.ofNullable(getInput.next()).orElse(String.valueOf(0))));
    }

    private static Currency getCurrency() {
        Scanner getInput = new Scanner(System.in);
        System.out.print("Enter account currency: ");
        return Currency.valueOf(Optional.ofNullable(getInput.next()).orElse("PLN"));
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
