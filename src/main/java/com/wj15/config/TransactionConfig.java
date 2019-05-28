package com.wj15.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

public class TransactionConfig {

    @Bean(name = "transactionManager15")
    public PlatformTransactionManager createTransactionManager(@Qualifier("dataSource15") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

}
