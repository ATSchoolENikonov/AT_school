package com.megabankcorp.system;

import com.megabankcorp.records.Account;

import java.math.BigDecimal;

public class Database {
    public void deposit(BigDecimal balance, Account acc) {
    }

    public void withdraw(BigDecimal balance, Account acc) {
    }

    protected void getAmount(Account account) {
    }

    void transfer(Account a, Account b) {
        deposit(a.getBalance(), a);
        withdraw(b.getBalance(), b);
    }
}
