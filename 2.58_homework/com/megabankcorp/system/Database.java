package com.megabankcorp.system;

import com.megabankcorp.records.Account;

import java.math.BigDecimal;

public abstract class Database {
    public abstract void deposit(BigDecimal balance, Account acc);


    abstract void withdraw(BigDecimal balance, Account acc);

    protected abstract void getAmount(Account account);

    void transfer(Account a, Account b,BigDecimal sum) {
        withdraw(sum, a);
        deposit(sum, b);
    }
}
