package com.wj09.dao.impl;

import com.wj09.dao.interfaces.IAccountDao;
import com.wj09.domain.Account;
import com.wj09.utils.ConnectionUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class AccountDaoImpl implements IAccountDao {


    private QueryRunner runner09;

    private ConnectionUtils connectionUtils;

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    public void setRunner09(QueryRunner runner09) {
        this.runner09 = runner09;
    }

    public List<Account> findAllCount() {
        try {
            return runner09.query(connectionUtils.getThreadLocalConnection(),"select * from my",new BeanListHandler<Account>(Account.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Account findAccountById(Integer accountId) {
        try {
            return runner09.query(connectionUtils.getThreadLocalConnection(),"select * from my where id = ?",new BeanHandler<Account>(Account.class),accountId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveAccount(Account account) {
        try {
            runner09.update(connectionUtils.getThreadLocalConnection(),"insert into my(id,name,money) values(?,?,?)",account.getId(),account.getName(),account.getMoney());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void updateAccount(Account account) {
        try {
            runner09.update(connectionUtils.getThreadLocalConnection(),"update my set name = ?,money = ? where id = ?",account.getName(),account.getMoney(),account.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteAccount(Integer accountId) {
        try {
            runner09.update(connectionUtils.getThreadLocalConnection(),"delete from my where id = ?",accountId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Account findAccountByName(String accountName) {
        try {
            List<Account> accountList = runner09.query(connectionUtils.getThreadLocalConnection(),"select * from my where name  = ?", new BeanListHandler<Account>(Account.class), accountName);
            if (null == accountList || accountList.size() == 0) {
                return null;
            }

            if (accountList.size() > 1) {
                throw new RuntimeException("结果集不唯一");
            }
            return accountList.get(0);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
