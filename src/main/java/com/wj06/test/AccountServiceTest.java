package com.wj06.test;

import com.wj06.domain.Account;
import com.wj06.service.interfaces.IAccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * 使用Junit单元测试，测试配置
 */
public class AccountServiceTest {

    @Test
    public void testFindAll() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService accountService = (IAccountService) applicationContext.getBean("accountService06");
        List<Account> allAccount = accountService.findAllAccount();
        for (Account account : allAccount) System.out.println(allAccount);
    }

    @Test
    public void testFindOne() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService accountService = (IAccountService) applicationContext.getBean("accountService06");
        Account account = accountService.findAccountById(1);
        System.out.println(account);
    }

    @Test
    public void testSave() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService accountService = (IAccountService) applicationContext.getBean("accountService06");
        Account account = new Account();
        account.setId(4);
        account.setName("dd");
        account.setMoney(100.0f);
        accountService.saveAccount(account);
    }

    @Test
    public void testUpdate() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService accountService = (IAccountService) applicationContext.getBean("accountService06");
        Account account = accountService.findAccountById(1);
        account.setMoney(200.0f);
        accountService.updateAccount(account);
    }

    @Test
    public void testDelete() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService accountService = (IAccountService) applicationContext.getBean("accountService06");
        accountService.deleteAccount(4);
    }

}
