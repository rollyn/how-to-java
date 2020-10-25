package com.ethanium;

import com.ethanium.model.Account;
import com.ethanium.service.AccountService;

import java.util.List;

public class App {


    public static void main(String[] args) {

        AccountService service = new AccountService();
        List<Account> accounts = service.get();
        for(Account account: accounts) {
            System.out.println( account.getId() );
        }
        Account account = new Account();
        account.setId(100L);
        account.setLastName("MOISES");
        account.setFirstName("ROLLYN");
        account.setBalance(1000f);
        service.create(account);

        accounts = service.get();
        for(Account acc: accounts) {
            System.out.println( acc );
        }

    }
}
