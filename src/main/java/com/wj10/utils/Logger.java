package com.wj10.utils;

/**
 * 用于记录日志的公共类
 */
public class Logger {

    /**
     * 用于打印日志，让其在切入点方法执行之前执行（切入点方法就是业务方法）
     */
    public void printLog() {
        System.out.println("Logger类中的方法printLog方法执行");
    }


    /**
     * 四种常用通知类型
     */

    public void after() {
        System.out.println("后置通知");
    }

    public void throwing() {
        System.out.println("异常通知");
    }

    public void before() {
        System.out.println("前置通知");
    }

    public void fina() {
        System.out.println("最终通知");
    }
}
