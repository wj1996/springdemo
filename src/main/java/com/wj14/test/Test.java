package com.wj14.test;

import com.wj14.service.interfaces.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    @org.junit.Test
    public void test1() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
//        IAccountDao accountDao = (IAccountDao) applicationContext.getBean("accountDao13");
        IAccountService accountService = (IAccountService) applicationContext.getBean("accountService14");
        accountService.transfer("aa","bb",10f);
    }
}
