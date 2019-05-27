package com.wj11.service.impl;


import com.wj11.service.interfaces.IAccountService;
import org.springframework.stereotype.Service;

/**
 * Spring基于注解的AOP 实现
 */
@Service("accountService11")
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
