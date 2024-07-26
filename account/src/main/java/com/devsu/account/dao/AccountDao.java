package com.devsu.account.dao;

import com.devsu.account.entities.Account;

import java.util.List;

public interface AccountDao {
    List<Account> findAll();
    Account findById(int id);
    Account save(Account account);
    void deleteById(int id);
}
