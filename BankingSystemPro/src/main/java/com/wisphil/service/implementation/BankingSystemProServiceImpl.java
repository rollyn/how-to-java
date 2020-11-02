package com.wisphil.service.implementation;

import com.wisphil.model.AccountDto;
import com.wisphil.model.entity.Account;
import com.wisphil.repository.BankingSystemProRepository;
import com.wisphil.service.BankingSystemProService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankingSystemProServiceImpl implements BankingSystemProService {

    @Autowired
    private BankingSystemProRepository repository;

    @Override
    public boolean createContact(AccountDto dto) {
        System.out.println("This is from the service....");

        Account account = new Account();
        account.setAccountID(  dto.getAccountID() );
        account.setName( dto.getName() );
        account.setBalance( dto.getBalance() );
        account.setType("SAVINGS");

        repository.save(account); // saving

        return true;
    }
}
