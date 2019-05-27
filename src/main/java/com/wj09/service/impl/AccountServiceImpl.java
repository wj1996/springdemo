package com.wj09.service.impl;

import com.wj09.dao.interfaces.IAccountDao;
import com.wj09.domain.Account;
import com.wj09.service.interfaces.IAccountService;
import com.wj09.utils.TransactionManager;

import java.util.List;

/**
 * 案例完善（转账方法引入）
 * 事务的控制都在业务层  
 */
public class AccountServiceImpl implements IAccountService {


    private TransactionManager txManager;

    private IAccountDao accountDao09;

    public void setAccountDao09(IAccountDao accountDao09) {
        this.accountDao09 = accountDao09;
    }

    public void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }

    public List<Account> findAllAccount() {
        return accountDao09.findAllCount();
    }

    public Account findAccountById(Integer accountId) {
        return accountDao09.findAccountById(accountId);
    }

    public void saveAccount(Account account) {
        try {
            txManager.beginTransaction();
            accountDao09.saveAccount(account);
            txManager.commit();
        } catch (Exception e) {
            txManager.rollback();
        } finally {
            txManager.relaese();
        }

    }

    public void updateAccount(Account account) {
        try {
            txManager.beginTransaction();
            accountDao09.updateAccount(account);
            txManager.commit();
        } catch (Exception e) {
            txManager.rollback();
        } finally {
            txManager.relaese();
        }

    }

    public void deleteAccount(Integer accountId) {
        try {
            txManager.beginTransaction();
            accountDao09.deleteAccount(accountId);
            txManager.commit();
        } catch (Exception e) {
            txManager.rollback();
        } finally {
            txManager.relaese();
        }

    }
    public void transfer(String sourceName, String targetName, Float money) {
        try {
            txManager.beginTransaction();
            Account source = accountDao09.findAccountByName(sourceName);
            Account target = accountDao09.findAccountByName(targetName);
            source.setMoney(source.getMoney() - money);
            target.setMoney(target.getMoney() + money);
            accountDao09.updateAccount(source);
            int i = 1 / 0;
            accountDao09.updateAccount(target);
            txManager.commit();
        } catch (Exception e) {
            e.printStackTrace();
            txManager.rollback();
        } finally {
            txManager.relaese();
        }

    }


}
