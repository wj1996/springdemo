package com.wj03.factory;

import com.wj03.service.impl.AccountServiceImpl;
import com.wj03.service.interfaces.IAccountService;

public class MyFactory {

    public IAccountService instance() {
        System.out.println("由指定工厂类创建");
        return new AccountServiceImpl();
    }

    public static IAccountService instanceStatic() {
        System.out.println("由指定工厂类静态方法创建");
        return new AccountServiceImpl();
    }
}
