package com.wj12.test;

import com.wj12.dao.interfaces.IAccountDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    @org.junit.Test
    public void test1() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        IAccountDao accountDao = (IAccountDao) applicationContext.getBean("accountDao12-2");
        System.out.println(accountDao.findAccountById(7));
    }
}
