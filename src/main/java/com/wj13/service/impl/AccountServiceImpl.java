package com.wj13.service.impl;


import com.wj13.dao.interfaces.IAccountDao;
import com.wj13.domain.Account;
import com.wj13.service.interfaces.IAccountService;

import java.util.List;

/**
 * 案例完善（转账方法引入）
 * 事务的控制都在业务层
 */
public class AccountServiceImpl implements IAccountService {


    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public List<Account> findAllAccount() {
        return null;
    }

    public Account findAccountById(Integer accountId) {
        return null;
    }

    public void saveAccount(Account account) {

    }

    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    public void deleteAccount(Integer accountId) {

    }

    public void transfer(String sourceName, String targetName, Float money) {
        Account source = accountDao.findAccountByName(sourceName);
        Account target = accountDao.findAccountByName(targetName);
        source.setMoney(source.getMoney() - money);
        target.setMoney(target.getMoney() + money);
        accountDao.updateAccount(source);
        int i = 1 / 0;
        accountDao.updateAccount(target);
    }
}
