package com.wj.service.impl;

import com.wj.dao.impl.AccountDaoImpl;
import com.wj.dao.interfaces.IAccountDao;
import com.wj.service.interfaces.IAccountService;
import com.wj.util.BeanFactory;

public class AccountServiceImpl implements IAccountService {

//    private IAccountDao accountDao = new AccountDaoImpl();
    private IAccountDao accountDao = (IAccountDao) BeanFactory.getBean("accountDao");
    public void saveAccount() {
        accountDao.saveAccount();
    }
}
