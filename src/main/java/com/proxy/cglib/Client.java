package com.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class Client {

    public static void main(String[] args) {
        /**
         * 动态代理
         *  特点：字节码随用随创建，随用随加载
         *  作用：不修改源码的基础上对源码增强
         *  分类：
         *      基于接口的动态代理
         *      基于子类的动态代理
         *  基于子类的动态代理
         *      涉及的类：Enhancer
         *      提供者：第三方cglib库
         *  如何创建代理对象：
         *      使用Enhancer类中的create方法
         *  创建代理对象要求：
         *      被代理类不能是最终类（final）
         *  create方法参数
         *      Class：字节码，指定被代理对象的字节码
         *      Callback:用于提供增强的代码
         *          一般写的都是该接口的子接口实现类（MethodInterceptor)
         *
         */
        final Producer producer = new Producer();
        Producer p = (Producer) Enhancer.create(Producer.class,new MethodInterceptor(){
            /**
             * 前三个参数和基于接口的一样
             *
             * @param o
             * @param method
             * @param objects
             * @param methodProxy  当前执行方法的代理对象
             * @return
             * @throws Throwable
             */
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                //1.增加方法
                Object returnValue = null;
                Float money = (Float) objects[0];
                if ("saleProduct".equals(method.getName())) {
                    returnValue = method.invoke(producer, money * 0.8f);
                }
                return returnValue;
            }
        });

        p.saleProduct(1000f);
    }
}
