package com.wisphil.service.implementation;

import com.wisphil.exception.BankingSystemProException;
import com.wisphil.model.AccountDto;
import com.wisphil.model.entity.Account;
import com.wisphil.repository.BankingSystemProRepository;
import com.wisphil.service.BankingSystemProService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BankingSystemProServiceImpl implements BankingSystemProService {

    @Autowired
    private BankingSystemProRepository repository;

    @Override
    public boolean createContact(AccountDto dto) {
        System.out.println("This is from the service....");

        if (dto.getBalance() == 0) {
            throw new BankingSystemProException("Balance should not be zero");
        }
        Account account = new Account();
        account.setAccountID(  dto.getAccountID() );
        account.setName( dto.getName() );
        account.setBalance( dto.getBalance() );
        account.setType("SAVINGS");

        repository.save(account); // saving

        return true;
    }

    @Override
    public List<AccountDto> getAll() {
        List<Account> accounts = repository.findAll();

        List<AccountDto> dto = accounts.stream().map(c -> {
            AccountDto accountDto = new AccountDto();
            accountDto.setName( c.getName() );
            accountDto.setAccountID( c.getAccountID() );
            accountDto.setBalance( c.getBalance() );
            return accountDto;
        }).collect(Collectors.toList());

        return dto;
    }

    @PreAuthorize("hasAuthority('USER')")
    @Override
    public void deleteAccount(String accountID) {
        System.out.println( "THIS IS DELETE MAPPING............."+accountID);
        repository.deleteById(accountID);
    }
}
