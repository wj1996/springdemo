package com.wj11.service.impl;


import com.wj11.service.interfaces.IAccountService;
import org.springframework.stereotype.Service;

/**
 * Spring基于注解的AOP 实现  后置和异常和最终执行顺序是跟基于XML的有一些区别的，最终会先执行
 * 这一点无法避免
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
