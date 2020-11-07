package com.wisphil.service;

import com.wisphil.model.Account;
import com.wisphil.model.Response;

public interface TransactionService {

    Response withdraw(Account account);
    Response deposit(Account account);

}
