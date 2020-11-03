package com.wisphil.controller;

import com.wisphil.model.Account;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class AccountController {

    List<Account> accounts = Arrays.asList(
        new Account("001","JOHN",10d),
        new Account("002","JAMES",20d),
        new Account("003","PETER",10d)
    );

    @GetMapping(value="/account/{accountID}", produces = { "application/xml", "text/xml" })
//    @GetMapping(value="/account/{accountID}")
    public Account get(@PathVariable String accountID) {
        for(Account account: accounts) {
            if (account.getAccountID().equals(accountID)) {
                return account;
            }
        }
        return null;
    }

    @GetMapping(value = "/account", produces = { "application/xml", "text/xml" })
//    @GetMapping(value = "/account")
    public List<Account> get() {
        return accounts;
    }


}
