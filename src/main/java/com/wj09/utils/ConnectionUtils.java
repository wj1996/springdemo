package com.wj09.utils;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * 连接的工具类
 */
public class ConnectionUtils {


    private ThreadLocal<Connection> tl = new ThreadLocal<Connection>();

    private DataSource dataSource;


    public Connection getThreadLocalConnection() {
        Connection connection = tl.get();
        try {
            if (null == connection) {
                connection = dataSource.getConnection();
                tl.set(connection);
            }
            return connection;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void removeConnection() {
        tl.remove();
    }

}
