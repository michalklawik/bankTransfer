package com.epamsystems.DAO;

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

    public void showAccount(int accountNumber) {
        if (accounts.isEmpty()) {
            System.out.println("Account not found!");
        } else {
            System.out.println(accounts.stream().filter(a -> a.getAccountNumber() == accountNumber).findAny().get().toString());
        }
        System.out.println();
    }

    public void listAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts loaded!");
        } else {
            System.out.println("Accounts:\n");
            accounts.stream().forEach(a -> System.out.println(a.toString() + "\n"));
        }
    }

    public void transferMoney(int sourceAccount, int destinyAccount, BigDecimal amount) {
        Account sourceAcc = accounts.stream().filter(a -> a.getAccountNumber() == sourceAccount).findAny().get();
        Account destinyAcc = accounts.stream().filter(a -> a.getAccountNumber() == destinyAccount).findAny().get();

        BigDecimal amountMultiplyer = getAmountMultiplyer(sourceAcc.getAccountCurrency(), destinyAcc.getAccountCurrency());

        if (sourceAcc.getAccountBalance().compareTo(amount) < 0) {
            System.out.println("Insufficient funds!");
        } else if (sourceAcc.getAccountCurrency() == destinyAcc.getAccountCurrency()) {
            sourceAcc.setAccountBalance(sourceAcc.getAccountBalance().subtract(amount));
            destinyAcc.setAccountBalance(destinyAcc.getAccountBalance().add(amount));
        } else {
            sourceAcc.setAccountBalance(sourceAcc.getAccountBalance().subtract(amount.multiply(amountMultiplyer)));
            destinyAcc.setAccountBalance(destinyAcc.getAccountBalance().add(amount.multiply(amountMultiplyer)));
        }
    }

    private BigDecimal getAmountMultiplyer(Currency sourceCurrency, Currency destinyCurrency) {
        if (sourceCurrency == Currency.PLN && destinyCurrency == Currency.EUR) {
            return BigDecimal.valueOf(1/4.2857);
        } else if (sourceCurrency == Currency.PLN && destinyCurrency == Currency.USD) {
            return BigDecimal.valueOf(1/3.6430);
        } else if (sourceCurrency == Currency.USD && destinyCurrency == Currency.PLN) {
            return BigDecimal.valueOf(3.6430);
        } else if (sourceCurrency == Currency.USD && destinyCurrency == Currency.EUR) {
            return BigDecimal.valueOf(3.6430/4.2857);
        } else if (sourceCurrency == Currency.EUR && destinyCurrency == Currency.PLN) {
            return BigDecimal.valueOf(4.2857);
        } else if (sourceCurrency == Currency.EUR && destinyCurrency == Currency.USD) {
            return BigDecimal.valueOf(4.2857/3.6430);
        }
        return BigDecimal.valueOf(0);
    }
}
