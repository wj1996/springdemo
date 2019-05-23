package com.wj04.ui;

import com.wj04.service.interfaces.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService accountService = (IAccountService) applicationContext.getBean("accountService04");
        System.out.println(accountService);
        IAccountService accountService2 = (IAccountService) applicationContext.getBean("accountService04-1");
        System.out.println(accountService2);
        IAccountService accountService3 = (IAccountService) applicationContext.getBean("accountService04-2");
        System.out.println(accountService3);
    }
}
