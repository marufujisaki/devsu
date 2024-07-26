package com.devsu.account.services;

import com.devsu.account.dao.AccountDao;
import com.devsu.account.dto.AccountDTO;
import com.devsu.account.entities.Account;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    private final AccountDao accountDao;

    public AccountService(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public List<Account> getAllAccounts() {
        return accountDao.findAll();
    }

    public Account getAccountById(int id) {
        return accountDao.findById(id);
    }

    public Account createAccount(AccountDTO dto) {
        Account account = new Account(dto.getAccountNumber(),dto.getType(),dto.getInitialBalance(),dto.isStatus(),dto.getClientId());
        return accountDao.save(account);
    }

    public Account updateAccount(int id, AccountDTO accountDetails) {
        Account account = accountDao.findById(id);
        if (account != null) {
            account.setAccountNumber(accountDetails.getAccountNumber());
            account.setType(accountDetails.getType());
            account.setInitialBalance(accountDetails.getInitialBalance());
            account.setStatus(accountDetails.isStatus());
            account.setClientId(accountDetails.getClientId());
            return accountDao.save(account);
        } else {
            return null;
        }
    }

    public void deleteAccount(int id) {
        accountDao.deleteById(id);
    }
}
