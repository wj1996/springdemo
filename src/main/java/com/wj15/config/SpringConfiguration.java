package com.wj15.config;

import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * spring的配置类，相当于bean.xml
 */
@Configuration  //该注解可写可不写，这个类需要传
@ComponentScan("com.wj15")
@Import({JdbcConfig.class,TransactionConfig.class})
@PropertySource("jdbc.properties")
@EnableTransactionManagement   //开启spring的事务注解
public class SpringConfiguration {
}
