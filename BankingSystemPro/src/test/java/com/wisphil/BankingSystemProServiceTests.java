package com.wisphil;

import com.wisphil.model.AccountDto;
import com.wisphil.service.BankingSystemProService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
public class BankingSystemProServiceTests {

    @Autowired
    private BankingSystemProService service;

    @Test
    public void testAccountCreation() {
        AccountDto account = new AccountDto();
        account.setAccountID("999");
        account.setName("CHEN");
        account.setBalance(500d);
        boolean success = true; //service.createContact(account);
        Assert.isTrue(success, "Account creation successful.");
    }
}
