package com.wj07.service.impl;

import com.wj07.dao.interfaces.IAccountDao;
import com.wj07.domain.Account;
import com.wj07.service.interfaces.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 基于注解方式的IOC案例
 */
@Service("accountService07")
public class AccountServiceImpl implements IAccountService {


    @Autowired
    private IAccountDao accountDao07;



    public List<Account> findAllAccount() {
        return accountDao07.findAllCount();
    }

    public Account findAccountById(Integer accountId) {
        return accountDao07.findAccountById(accountId);
    }

    public void saveAccount(Account account) {
        accountDao07.saveAccount(account);
    }

    public void updateAccount(Account account) {
        accountDao07.updateAccount(account);
    }

    public void deleteAccount(Integer accountId) {
        accountDao07.deleteAccount(accountId);
    }
}
