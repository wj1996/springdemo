package com.wj08.test;

import com.wj08.config.SpringConfiguration;
import com.wj08.domain.Account;
import com.wj08.service.interfaces.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 使用Junit单元测试，测试配置(AnnotationConfigApplicationContext的使用)
 * Spring整合Junit
 *      1. 导入Spring整合Junit的jar包
 *      2. 使用Junit提供的一个注解把原有的main方法替换了，替换成spring替换的
 *      3. spring和IOC创建时基于xml的还是注解的，说明位置
 *          ContextConfiguration
 *              locations:指定xml文件的位置，加上classpath关键字，表示在路径下面
 *              classes:指定注解类所在位置
 *  当使用spring5.x版本的时候，要求Junit的jar必须是4.12及以上
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class AccountServiceTest {


    @Autowired
    private IAccountService accountService08;

    @Test
    public void testFindAll2() {
        List<Account> allAccount = accountService08.findAllAccount();
        for (Account account : allAccount) System.out.println(account);
    }



    @Test
    public void testFindAll() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        IAccountService accountService = (IAccountService) applicationContext.getBean("accountService08");
        List<Account> allAccount = accountService.findAllAccount();
        for (Account account : allAccount) System.out.println(account);
    }

    @Test
    public void testFindOne() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        IAccountService accountService = (IAccountService) applicationContext.getBean("accountService08");
        Account account = accountService.findAccountById(1);
        System.out.println(account);
    }

    @Test
    public void testSave() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        IAccountService accountService = (IAccountService) applicationContext.getBean("accountService08");
        Account account = new Account();
        account.setId(4);
        account.setName("dd");
        account.setMoney(100.0f);
        accountService.saveAccount(account);
    }

    @Test
    public void testUpdate() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        IAccountService accountService = (IAccountService) applicationContext.getBean("accountService08");
        Account account = accountService.findAccountById(1);
        account.setMoney(200.0f);
        accountService.updateAccount(account);
    }

    @Test
    public void testDelete() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        IAccountService accountService = (IAccountService) applicationContext.getBean("accountService08");
        accountService.deleteAccount(4);
    }

}
