package com.ethanium;

import com.ethanium.model.Account;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FakeData {

    public List<Account> getAccounts() {
        List<Account> accounts = new ArrayList<>();

        Account account = new Account();
        account.setId(1000L);
        account.setFirstName("Russell");
        account.setLastName("Peter");
        account.setBalance(1000f);
        accounts.add(account);

        account = new Account();
        account.setId(1002L);
        account.setFirstName("Chu");
        account.setLastName("Peter");
        account.setBalance(2000f);
        accounts.add(account);

        account = new Account();
        account.setId(1005L);
        account.setFirstName("Hart");
        account.setLastName("Kevin");
        account.setBalance(2500f);
        accounts.add(account);

        account = new Account();
        account.setId(2000L);
        account.setFirstName("Brooks");
        account.setLastName("Mel");
        account.setBalance(1500f);
        accounts.add(account);

        account = new Account();
        account.setId(2100L);
        account.setFirstName("Cosby");
        account.setLastName("Bill");
        account.setBalance(800f);
        accounts.add(account);

        account = new Account();
        account.setId(2130L);
        account.setFirstName("Chappelle");
        account.setLastName("Dave");
        account.setBalance(1700f);
        accounts.add(account);

        return accounts;
    }
}
