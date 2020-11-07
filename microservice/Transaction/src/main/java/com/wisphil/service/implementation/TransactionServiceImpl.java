package com.wisphil.service.implementation;

import com.wisphil.model.Account;
import com.wisphil.model.Response;
import com.wisphil.service.TransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TransactionServiceImpl implements TransactionService {

    @Override
    public Response withdraw(Account account) {
        log.info("Withdraw executed....");

        Response response = new Response();
        response.setAccountID( account.getAccountID() );
        response.setAmount( account.getAmount() );
        response.setSuccess(true);
        return response;
    }

    @Override
    public Response deposit(Account account) {
        log.info("deposit executed....");

        Response response = new Response();
        response.setAccountID( account.getAccountID() );
        response.setAmount( account.getAmount() );
        response.setSuccess(true);
        return response;
    }
}
