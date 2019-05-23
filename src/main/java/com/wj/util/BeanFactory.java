package com.wj.util;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class BeanFactory {

    //定义一个properties对象
    private static Properties props;

    //定义一个容器，存放对象
    static Map<String,Object> beans;

    static {
        props = new Properties();
        try {
            props.load(BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties"));
            beans = new HashMap<String, Object>();
            Enumeration<Object> keys = props.keys();
            while (keys.hasMoreElements()) {
                String key = keys.nextElement().toString();
                String basepath = props.getProperty(key);
                Object value = Class.forName(basepath).newInstance();
                beans.put(key,value);
            }
        } catch (Exception e) {
            throw new ExceptionInInitializerError("初始化propert失败");
        }
    }

   /* public static Object getBean(String beanName) {
        Object bean = null;
        String beanPath = props.getProperty(beanName);
        try {
            bean = Class.forName(beanPath).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }*/

    public static Object getBean(String beanName) {
        return beans.get(beanName);
    }
}
