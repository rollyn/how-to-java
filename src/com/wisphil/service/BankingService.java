package com.wisphil.service;

import com.wisphil.dao.AccountDao;
import com.wisphil.exception.AccountException;
import com.wisphil.model.CheckingAccount;

public class BankingService extends Banking {

    private AccountDao dao = new AccountDao();

    // behavior
    public boolean createAccount(CheckingAccount account) throws AccountException {
        diplayAccount();
        if (account.getBalance() == 0) {
            throw new AccountException("Cannot create account with zero balance");
        }
        boolean success = dao.saveAccount(account);
        return success;
    }


    @Override
    public boolean withdraw() {
        System.out.println("Withdrawing....");
        return false;
    }

    @Override
    public boolean deposit() {
        return false;
    }
}
