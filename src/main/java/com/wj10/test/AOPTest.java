package com.wj10.test;

import com.wj10.service.interfaces.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试AOP
 */
public class AOPTest {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService accountService = (IAccountService) applicationContext.getBean("accountService10");
        accountService.saveAccount();
        accountService.updateAccount(1);
    }
}
