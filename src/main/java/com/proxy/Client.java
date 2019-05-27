package com.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Client {

    public static void main(String[] args) {
        /**
         * 之前的做法
         */
        /*Producer producer = new Producer();
        producer.saleProduct(10000f);
        producer.afterService(1000f);*/

        /**
         * 动态代理
         *  特点：字节码随用随创建，随用随加载
         *  作用：不修改源码的基础上对源码增强
         *  分类：
         *      基于接口的动态代理
         *      基于子类的动态代理
         *  基于接口的动态代理
         *      涉及的类：Proxy
         *      提供方：jdk
         *  如何创建代理对象
         *      使用Proxy类的newProxyInstance方法
         *  创建代理对象的要求：
         *      被代理类最少实现一个接口，如果没有则不能使用
         *  newProxyInstance参数
         *      ClassLoader
         *          用于加载代理对象的字节码，和被代理对象使用相同的类加载器，固定写法
         *      Class[]
         *          它是用于让代理对象和被代理对象有相同方法。固定写法
         *      InvocationHandler
         *          如何写代理，一般都是写一个该接口的实现类，通常情况下匿名内部类
         *
         */
        final Producer producer = new Producer();
        IProducer instance = (IProducer) Proxy.newProxyInstance(producer.getClass().getClassLoader(), producer.getClass().getInterfaces(), new InvocationHandler() {

            /**
             * 执行被代理对象的任何方法都会经过该方法
             * @param proxy 代理对象的引用
             * @param method 当前执行的方法
             * @param args 当前执行方法所需要的参数
             * @return 和被代理方法具有相同的返回值
             * @throws Throwable
             */
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //1.增加方法
                Object returnValue = null;
                Float money = (Float) args[0];
                if ("saleProduct".equals(method.getName())) {
                    returnValue = method.invoke(producer, money * 0.8f);
                }
                return returnValue;
            }
        });

        instance.saleProduct(10000f);


    }
}
