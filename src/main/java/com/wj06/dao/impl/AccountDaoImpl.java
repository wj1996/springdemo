package com.wj06.dao.impl;

import com.wj06.dao.interfaces.IAccountDao;
import com.wj06.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class AccountDaoImpl implements IAccountDao {


    private QueryRunner runner;

    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }

    public List<Account> findAllCount() {
        try {
            return runner.query("select * from my",new BeanListHandler<Account>(Account.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Account findAccountById(Integer accountId) {
        try {
            return runner.query("select * from my where id = ?",new BeanHandler<Account>(Account.class),accountId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveAccount(Account account) {
        try {
            runner.update("insert into my(id,name,money) values(?,?,?)",account.getId(),account.getName(),account.getMoney());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void updateAccount(Account account) {
        try {
            runner.update("update my set name = ?,money = ? where id = ?",account.getName(),account.getMoney(),account.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteAccount(Integer accountId) {
        try {
            runner.update("delete my where id = ?",accountId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
