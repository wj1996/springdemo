package com.wj09.test;

import com.wj09.config.SpringConfiguration;
import com.wj09.domain.Account;
import com.wj09.service.interfaces.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
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
    private IAccountService accountService09;


    @Test
    public void testTransfer() {
        accountService09.transfer("aa","bb",10f);
    }



}
