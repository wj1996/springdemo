package com.wj08.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;

/**
 * spring数据库连接相关的配置类
 */
public class JdbcConfig {

    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    @Value("${jdbc.url2}")
    private String url2;

    /**
     * 创建一个QueryRunner对象
     *  Qualifier注解可以作用于方法参数上面，指定使用的Bean的id
     * @param dataSource
     * @return
     */
    @Bean(name = "queryRunner08")
    @Scope("prototype")
    public QueryRunner createQueryRunner(@Qualifier("dataSource1") DataSource dataSource) {
        return new QueryRunner(dataSource);
    }

    /**
     * 创建数据源
     */
    @Bean(name = "dataSource1")
    public DataSource createDataSource() {
        try {
            ComboPooledDataSource ds = new ComboPooledDataSource();
            ds.setDriverClass(driver);
            ds.setJdbcUrl(url);
            ds.setUser(username);
            ds.setPassword(password);
            return ds;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Bean(name = "dataSource2")
    public DataSource createDataSource2() {
        try {
            ComboPooledDataSource ds = new ComboPooledDataSource();
            ds.setDriverClass(driver);
            ds.setJdbcUrl(url2);
            ds.setUser(username);
            ds.setPassword(password);
            return ds;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


}
