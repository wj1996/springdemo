package com.wj10.service.impl;


import com.wj10.service.interfaces.IAccountService;

/**
 * Spring基于XML的AOP 实现
 */
public class AccountServiceImpl implements IAccountService {


    public void saveAccount() {
        System.out.println("save");
    }

    public void updateAccount(int i) {
        System.out.println("update " + i);
    }

    public int deleteAccount() {
        System.out.println("delete");
        return 0;
    }
}
