package com.wj13.test;

import com.wj13.service.interfaces.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    @org.junit.Test
    public void test1() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
//        IAccountDao accountDao = (IAccountDao) applicationContext.getBean("accountDao13");
        IAccountService accountService = (IAccountService) applicationContext.getBean("accountService13");
        accountService.transfer("aa","bb",10f);
    }
}
