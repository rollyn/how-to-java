package com.wisphil.service;

import com.wisphil.model.AccountDto;

import java.util.List;

public interface BankingSystemProService {

    boolean createContact(AccountDto account);
    List<AccountDto> getAll();

    void deleteAccount(String accountID);
}
