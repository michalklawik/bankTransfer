package com.epamsystems.DAO;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Account {

    private int accountNumber;
    private BigDecimal accountBalance;
    private Currency accountCurrency;
    private Customer customer;

    public Account(int accountNumber, BigDecimal accountBalance, Currency accountCurrency, Customer customer) {
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
        this.accountCurrency = accountCurrency;
        this.customer = customer;
    }

    public static List<Account> getAccounts(List<String> csvAccounts) {
        Function<String, Account> createAccount = s -> new Account(Integer.valueOf(s.split(",")[0]),
                BigDecimal.valueOf(Double.valueOf(s.split(",")[3])),
                Currency.valueOf(s.split(",")[4].toUpperCase()),
                new Customer(s.split(",")[1], s.split(",")[2]));
        return csvAccounts.stream().map(createAccount).collect(Collectors.toList());
    }

    public static Account getAccount(List<Account> accounts, int accountNumber) {
        return accounts.stream().filter(a -> a.getAccountNumber() == accountNumber).findFirst().orElseThrow(NoSuchElementException::new);
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }

    public Currency getAccountCurrency() {
        return accountCurrency;
    }

    public void setAccountCurrency(Currency accountCurrency) {
        this.accountCurrency = accountCurrency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return accountNumber == account.accountNumber &&
                Objects.equals(accountBalance, account.accountBalance) &&
                accountCurrency == account.accountCurrency &&
                Objects.equals(customer, account.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber, accountBalance, accountCurrency, customer);
    }

    @Override
    public String toString() {
        return "Account number: " + accountNumber + "\n" +
                "First name: " + customer.getName() + "\n" +
                "Last name: " + customer.getSurName() + "\n" +
                "Account Balance: " + accountBalance + "\n" +
                "Account Currency: " + accountCurrency;
    }
}
