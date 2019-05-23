package com.wj03.ui;

import com.wj03.factory.MyFactory;
import com.wj03.service.interfaces.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService accountService = (IAccountService) applicationContext.getBean("accountService03");
        IAccountService service = (IAccountService) applicationContext.getBean("accountService03-1");

        System.out.println(service);

        IAccountService service2 = (IAccountService) applicationContext.getBean("accountService03-2");

        System.out.println(service2);
    }
}
