package com.wj09.dao.impl;

import com.wj09.dao.interfaces.IAccountDao;
import com.wj09.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository("accountDao09")
public class AccountDaoImpl implements IAccountDao {


    @Autowired
    @Qualifier("queryRunner08")
    private QueryRunner runner;

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
            runner.update("delete from my where id = ?",accountId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Account findAccountByName(String accountName) {
        try {
            List<Account> accountList = runner.query("select * from my where name  = ?", new BeanListHandler<Account>(Account.class), accountName);
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