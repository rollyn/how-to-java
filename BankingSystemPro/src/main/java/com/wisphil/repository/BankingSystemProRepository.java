package com.wisphil.repository;

import com.wisphil.model.entity.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BankingSystemProRepository extends CrudRepository<Account, String> {

    List<Account> findByName(String n);
    List<Account> findByType(String t);
    Account findByNameAndType(String name, String type);
    List<Account> findByBalanceGreaterThan(Double balance);

    List<Account> findAll();

}
