package com.wj09.utils;

import java.sql.SQLException;

public class TransactionManager {


    private ConnectionUtils connectionUtils;

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    public void beginTransaction() {
        try {
            connectionUtils.getThreadLocalConnection().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void commit() {
        try {
            connectionUtils.getThreadLocalConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void rollback() {
        try {
            connectionUtils.getThreadLocalConnection().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionUtils.removeConnection();
        }
    }

    public void relaese() {
        try {
            connectionUtils.getThreadLocalConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionUtils.removeConnection();
        }
    }

}
