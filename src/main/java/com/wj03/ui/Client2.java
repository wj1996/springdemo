package com.wj03.ui;

import com.wj03.service.interfaces.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client2 {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService accountService = (IAccountService) applicationContext.getBean("accountService03-3");
        //如果想看见销毁，需要手动关闭容器(由于ApplicationContext中是没有close方法的，需要调用ClassPathXmlApplicationContext中的close方法)
        ((ClassPathXmlApplicationContext) applicationContext).close();
    }
}
