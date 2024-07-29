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

    public List<AccountDTO> getAllAccounts() {
        return accountDao.findAll().stream().map(x -> new AccountDTO(x.getId(),x.getAccountNumber(),x.getType() == AccountDTO.TYPE_AHORRO ? AccountDTO.AHORRO : AccountDTO.CORRIENTE,x.getInitialBalance(),x.isStatus(),x.getClientId())).toList();
    }

    public Account getAccountById(int id) {
        return accountDao.findById(id);
    }

    public AccountDTO createAccount(AccountDTO dto) {
        Account account = new Account(dto.getAccountNumber(),dto.getType(),dto.getInitialBalance(),dto.isStatus(),dto.getClientId());
        accountDao.save(account);
        return new AccountDTO(account.getId(),account.getAccountNumber(),account.getType() == AccountDTO.TYPE_AHORRO ? AccountDTO.AHORRO : AccountDTO.CORRIENTE,account.getInitialBalance(),account.isStatus(),account.getClientId());
    }

    public AccountDTO updateAccount(int id, AccountDTO accountDetails) {
        Account account = accountDao.findById(id);
        if (account != null) {
            account.setAccountNumber(accountDetails.getAccountNumber());
            account.setType(accountDetails.getType());
            account.setInitialBalance(accountDetails.getInitialBalance());
            account.setStatus(accountDetails.isStatus());
            account.setClientId(accountDetails.getClientId());
            accountDao.save(account);
            return new AccountDTO(account.getId(),account.getAccountNumber(),account.getType() == AccountDTO.TYPE_AHORRO ? AccountDTO.AHORRO : AccountDTO.CORRIENTE,account.getInitialBalance(),account.isStatus(),account.getClientId());
        } else {
            return null;
        }
    }

    public void deleteAccount(int id) {
        accountDao.deleteById(id);
    }
}
