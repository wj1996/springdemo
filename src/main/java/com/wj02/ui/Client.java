package com.wj02.ui;

import com.wj02.dao.interfaces.IAccountDao;
import com.wj02.service.interfaces.IAccountService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Client {

    /**
     * 获取spring的IOC核心容器
     * ApplicationContext的三个常用实现类
     *  ClassPathXmlApplicationContext：可以加载类路径下的配置文件，要求:配置文件必须在类路径下面
     *  FileSystemXmlApplicationContext：可以加载任意磁盘路径下面的配置文件（必须有访问权限）
     *  AnnotationConfigApplicationContext：用于读取注解创建容器的
     * 核心容器的两个接口
     *  ApplicationContext  单例对象适用   采用此接口定义容器对象
     *      在创建核心容器时，创建对象的策略是采用立即加载的方式，读取完配置文件马上就创建配置文件中的对象
     *  BeanFactory  多例对象适用
     *      在创建核心容器时，创建对象的策略采用的是延迟加载的方式，什么时间需要使用再创建
     * @param args
     */
    public static void main(String[] args) {
       /* ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService accountService = (IAccountService) applicationContext.getBean("accountService");
        IAccountDao accountDao = applicationContext.getBean("accountDao",IAccountDao.class);

        System.out.println(accountService + "," + accountDao);*/
       /*BeanFactory*/
        Resource resource = new ClassPathResource("bean.xml");
        BeanFactory beanFactory = new XmlBeanFactory(resource);
        System.out.println(beanFactory.getBean("accountService"));
    }
}
