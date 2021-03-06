package com.wj06.service.impl;

import com.wj06.dao.interfaces.IAccountDao;
import com.wj06.domain.Account;
import com.wj06.service.interfaces.IAccountService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 基于XML方式的IOC案例
 */
public class AccountServiceImpl implements IAccountService {


    private IAccountDao accountDao;


    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public List<Account> findAllAccount() {
        return accountDao.findAllCount();
    }

    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);
    }

    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    public void deleteAccount(Integer accountId) {
        accountDao.deleteAccount(accountId);
    }
}
