package com.wisphil.controller;

import com.wisphil.model.Account;
import com.wisphil.model.Response;
import com.wisphil.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/api/v1/transaction")
public class TransactionController {

    @Autowired
    private TransactionService service;

    @PostMapping("/withdraw")
    public Response withdraw(@RequestBody Account account) {
        return service.withdraw(account);
    }

    @PostMapping("/deposit")
    public Response deposit(@RequestBody Account account) {
        return service.deposit(account);
    }
}
