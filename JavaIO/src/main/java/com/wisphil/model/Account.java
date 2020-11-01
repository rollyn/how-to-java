package com.wisphil.model;

import java.io.Serializable;

public class Account implements Serializable  {
    private Long serialVersionUID = 1L;

    private String accountID;
    private String name;
    private Double balance;

    public Account(String accountID, String name, Double balance) {
        this.accountID = accountID;
        this.name = name;
        this.balance = balance;
    }

    public String getAccountID() {
        return accountID;
    }

    public String getName() {
        return name;
    }

    public Double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountID='" + accountID + '\'' +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }
}
