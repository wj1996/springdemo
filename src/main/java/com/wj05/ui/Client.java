package com.wj05.ui;

import com.wj05.dao.interfaces.IAccountDao;
import com.wj05.service.interfaces.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService accountService = (IAccountService) applicationContext.getBean("accountServiceImpl");
        System.out.println(accountService);
        IAccountDao accountDao = (IAccountDao) applicationContext.getBean("accountDao05");
        System.out.println(accountDao);
        accountService.saveAccount();

        ((ClassPathXmlApplicationContext) applicationContext).close();
    }
}
