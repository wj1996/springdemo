package com.wj.ui.client;

import com.wj.service.impl.AccountServiceImpl;
import com.wj.service.interfaces.IAccountService;
import com.wj.util.BeanFactory;

public class Client {

    public static void main(String[] args) {
//        IAccountService accountService = new AccountServiceImpl();
        IAccountService accountService = (IAccountService) BeanFactory.getBean("accountService");
        for (int i = 0; i < 5; i++) {
            IAccountService accountService2 = (IAccountService) BeanFactory.getBean("accountService");
            System.out.println(accountService2);
        }
        accountService.saveAccount();
    }
}
