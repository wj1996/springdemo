package com.wj09.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * 该类是一个配置类，它的作用和bean.xml是一样的
 * spring中的新注解
 *  Configuration
 *      作用：指定当前类是一个配置类
 *      细节：
 *          当配置类作为AnnotationConfigApplicationContext创建的参数时，可以不写
 *  ComponentScan
 *      作用：用于通过指定注解指定spring在创建容器时要扫描的包
 *      属性：
 *          value：它和basePackages的作用是一样的都是用于指定创建容器时要扫描的包
 *                  使用此注解就等同于在xml文件中配置
 *   Bean
 *      作用：用于把当前方法的返回值作为bean对象存入spring的IOC容器中
 *      属性：
 *          name：用于指定bean的id，默认值是当前方法的名称
 *      细节：
 *          当使用注解配置方法时，如果方法有参数，spring框架会去容器中查找是否有可用的bean对象
 *          查找的方式和Autowired注解的是一样的
 *   PropertySource
 *       作用：用于指定properties文件的为孩子
 *       属性：
 *          value：指定文件的名称和路径
 *              关键字：classpath：表示类路径下面
 *   Import
 *      作用：导入其他的配置类
 */
@Configuration
@ComponentScan(basePackages = "com.wj09")
@Import(JdbcConfig.class)
@PropertySource("classpath:jdbc.properties")
public class SpringConfiguration {


}
