package com.wj09.service.impl;

import com.wj09.dao.interfaces.IAccountDao;
import com.wj09.domain.Account;
import com.wj09.service.interfaces.IAccountService;

import java.util.List;

/**
 * 案例完善（转账方法引入）
 * 事务的控制都在业务层  
 */
public class AccountService2Impl implements IAccountService {



    private IAccountDao accountDao09;

    public void setAccountDao09(IAccountDao accountDao09) {
        this.accountDao09 = accountDao09;
    }


    public List<Account> findAllAccount() {
        return accountDao09.findAllCount();
    }

    public Account findAccountById(Integer accountId) {
        return accountDao09.findAccountById(accountId);
    }

    public void saveAccount(Account account) {
        accountDao09.saveAccount(account);

    }

    public void updateAccount(Account account) {
        accountDao09.updateAccount(account);

    }

    public void deleteAccount(Integer accountId) {
        accountDao09.deleteAccount(accountId);
    }
    public void transfer(String sourceName, String targetName, Float money) {
        Account source = accountDao09.findAccountByName(sourceName);
        Account target = accountDao09.findAccountByName(targetName);
        source.setMoney(source.getMoney() - money);
        target.setMoney(target.getMoney() + money);
        accountDao09.updateAccount(source);
//        int i = 1 / 0;
        accountDao09.updateAccount(target);

    }


}
