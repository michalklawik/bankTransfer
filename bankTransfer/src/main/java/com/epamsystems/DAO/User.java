package com.epamsystems.DAO;

import com.epamsystems.Service.CSVUtil;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;


public class User {

    private List<Account> accounts;

    {
        try {
            accounts = Account.getAccounts(CSVUtil.readCSV());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public void transferMoney(int sourceAccount, int destinyAccount, BigDecimal amount) {
        Account sourceAcc = accounts.stream().filter(a -> a.getAccountNumber() == sourceAccount).findAny().get();
        Account destinyAcc = accounts.stream().filter(a -> a.getAccountNumber() == destinyAccount).findAny().get();

        BigDecimal amountMultiplier = getAmountMultiplier(sourceAcc.getAccountCurrency(), destinyAcc.getAccountCurrency());

        if (sourceAcc.getAccountBalance().compareTo(amount) < 0) {
            System.out.println("Insufficient funds!");
        } else if (sourceAcc.getAccountCurrency() == destinyAcc.getAccountCurrency()) {
            sourceAcc.setAccountBalance(sourceAcc.getAccountBalance().subtract(amount));
            destinyAcc.setAccountBalance(destinyAcc.getAccountBalance().add(amount));
        } else {
            sourceAcc.setAccountBalance(sourceAcc.getAccountBalance().subtract(amount.multiply(amountMultiplier)));
            destinyAcc.setAccountBalance(destinyAcc.getAccountBalance().add(amount.multiply(amountMultiplier)));
        }
    }

    private BigDecimal getAmountMultiplier(Currency sourceCurrency, Currency destinyCurrency) {
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
