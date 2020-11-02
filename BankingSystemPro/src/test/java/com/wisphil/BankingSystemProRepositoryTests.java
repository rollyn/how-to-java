package com.wisphil;

import com.wisphil.model.entity.Account;
import com.wisphil.repository.BankingSystemProRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@SpringBootTest
class BankingSystemProRepositoryTests {

    @Autowired
    private BankingSystemProRepository repository;

    @Test
    public void testFindByIdNotOptional() {
        Account account = repository.findById("555").orElse(null);
        Assert.isNull(account, "Account not found.");
    }

    @Test
    public void testFindByIdNotExisting() {
        Optional<Account> account = repository.findById("555");
        if (account.isPresent()) {
            System.out.println( account );
        } else {
            System.out.println("Account not found.");
        }
    }

    @Test
    public void testFindByName() {
        List<Account> accounts = repository.findByName("ROLLYN");
        accounts.forEach(c -> {
            System.out.println( c );
        });
    }

    @Test
    public void testCreateAccount() {
        Account account = new Account();
        account.setAccountID("009");
        account.setName("ROLLYN");
        account.setBalance(200d);
        account.setType("CHECKING");

       // repository.save(account);

    }

    @Test
    public void testFindAll() {
        repository.findAll().forEach(c -> {
            System.out.println( c );
        });
    }

    @Test
    public void testFindByType() {
        repository.findByType("SAVINGS").forEach(c -> {
            System.out.println( c );
        });
    }

    @Test
    public void testAndOperation() {
        Account account = repository.findByNameAndType("ROLLYN","CHECKING");
        System.out.println( account );
    }

    @Test
    public void testGreaterThanOperation() {
        List<Account> accounts = repository.findByBalanceGreaterThan(100d);
        accounts.forEach(c -> {
            System.out.println( c );
        });
    }
}
