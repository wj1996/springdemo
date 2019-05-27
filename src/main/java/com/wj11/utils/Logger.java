package com.wj11.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 用于记录日志的公共类
 */
@Component("logger2")
@Aspect  //表示当前类是一个切面类

public class Logger {

    /**
     * 用于打印日志，让其在切入点方法执行之前执行（切入点方法就是业务方法）
     */
    public void printLog() {
        System.out.println("Logger类中的方法printLog方法执行");
    }


    @Pointcut("execution(* com.wj11.service.impl.*.*(..))")
    private void pt1() {

    }


    /**
     * 四种常用通知类型
     */

//    @AfterReturning("pt1()")
    public void after() {
        System.out.println("后置通知");
    }

//    @AfterThrowing("pt1()")
    public void throwing() {
        System.out.println("异常通知");
    }

//    @Before("pt1()")
    public void before() {
        System.out.println("前置通知");
    }

//    @After("pt1()")
    public void fina() {
        System.out.println("最终通知");
    }

    /**
     * 环绕通知
     *  问题：
     *      当配置了环绕通知后，切入点方法没有执行，通知方法执行了
     *  解决：
     *      Spring框架提供一个接口，ProceedingJoinPoint 该接口有一个方法process，此方法就相当于明确调用切入点方法
     *      该接口可以作为环绕通知的方法参数，在程序执行时，spring框架会为我们提供该接口的实现类供我们使用
     *
     *  Spring中的环绕通知
     *      是sprig框架为我们提供的一种可以在代码中手动控制增强方法何时执行
     */
    @Around("pt1()")
    public Object around(ProceedingJoinPoint pjp) {
        Object retValue = null;
        try {
            Object[] args = pjp.getArgs(); //方法执行所需的参数
            retValue = pjp.proceed(args);
            System.out.println("环绕");
            return retValue;
        } catch (Throwable throwable) {
            throw new RuntimeException(throwable);
        } finally {

        }

    }
}
