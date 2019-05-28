package com.wj15.test;

import com.wj15.config.SpringConfiguration;
import com.wj15.service.interfaces.IAccountService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class Test {


    @Autowired
    private IAccountService accountService;


    @org.junit.Test
    public void test1() {
        accountService.transfer("aa","bb",10f);
    }
}
