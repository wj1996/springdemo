package com.wj09.factory;

import com.wj09.service.interfaces.IAccountService;
import com.wj09.utils.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 用于创建Service的代理对象的工厂
 */
public class BeanFactory {

    private IAccountService accountService;
    private TransactionManager txManager;

    /**
     * 注意此处final的添加
     * @param accountService
     */
    public final void setAccountService(IAccountService accountService) {
        this.accountService = accountService;
    }

    public void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }

    /**
     * 获取代理对象
     * @return
     */
    public IAccountService getAccountService() {
        return (IAccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(), accountService.getClass().getInterfaces(),
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        /**
                         * 添加事务的支持
                         */
                        Object retValue = null;
                        try {
                            txManager.beginTransaction();
                            System.out.println("开始执行Proxy");
                            retValue = method.invoke(accountService,args);
                            txManager.commit();
                        } catch (Exception e) {
                            e.printStackTrace();
                            System.out.println("proxy 事务回滚");
                            txManager.rollback();
                        } finally {
                            txManager.relaese();
                        }
                        return retValue;
                    }
                });
    }
}
