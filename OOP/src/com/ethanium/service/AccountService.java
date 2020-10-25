package com.ethanium.service;

import com.ethanium.FakeData;
import com.ethanium.model.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AccountService {

    List<Account> accounts = new ArrayList<>();

    public boolean create(Account account) {
        accounts.add(account);
        return true;
    }

    public List<Account> get() {
        return accounts;
    }

    public Account getById(Long id) {
        List<Account> acc =  accounts.stream().filter(c -> c.getId().equals(id)).collect(Collectors.toList());
        return acc.get(0);
    }


}
