package com.megabankcorp.records;

import java.math.BigDecimal;

public class Account{
    private BigDecimal balance;
    private long accountNumber;
    private long accountClient;

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public long getAccountClient() {
        return accountClient;
    }

    public void setAccountClient(long accountClient) {
        this.accountClient = accountClient;
    }
}
