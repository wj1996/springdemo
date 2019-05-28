package com.wj15.service.impl;


import com.wj15.dao.interfaces.IAccountDao;
import com.wj15.domain.Account;
import com.wj15.service.interfaces.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 基于纯注解的spring事务控制
 */
@Service("accountService15")
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true) //只读型  这样配置很麻烦 不如xml的配置，这样每写一个不一样的都需要重新配置
public class AccountServiceImpl implements IAccountService {


    @Autowired
    private IAccountDao accountDao;


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

    @Transactional(propagation = Propagation.REQUIRED,readOnly = false) //读写型
    public void transfer(String sourceName, String targetName, Float money) {
        Account source = accountDao.findAccountByName(sourceName);
        Account target = accountDao.findAccountByName(targetName);
        source.setMoney(source.getMoney() - money);
        target.setMoney(target.getMoney() + money);
        accountDao.updateAccount(source);
//        int i = 1 / 0;
        accountDao.updateAccount(target);
    }
}
