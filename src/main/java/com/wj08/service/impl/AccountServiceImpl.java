package com.wj08.service.impl;

import com.wj08.dao.interfaces.IAccountDao;
import com.wj08.domain.Account;
import com.wj08.service.interfaces.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 基于注解方式的IOC案例
 * 将spring配置文件中的内容全部采用注解方式实现
 */
@Service("accountService08")
public class AccountServiceImpl implements IAccountService {


    @Autowired
    private IAccountDao accountDao08;

    public List<Account> findAllAccount() {
        return accountDao08.findAllCount();
    }

    public Account findAccountById(Integer accountId) {
        return accountDao08.findAccountById(accountId);
    }

    public void saveAccount(Account account) {
        accountDao08.saveAccount(account);
    }

    public void updateAccount(Account account) {
        accountDao08.updateAccount(account);
    }

    public void deleteAccount(Integer accountId) {
        accountDao08.deleteAccount(accountId);
    }
}
