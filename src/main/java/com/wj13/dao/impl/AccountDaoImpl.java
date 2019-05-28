package com.wj13.dao.impl;

import com.wj13.dao.interfaces.IAccountDao;
import com.wj13.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

/**
 * 集成spring的或者集成自己写的（自己写的方便进行注解开发）
 */
public class AccountDaoImpl extends JdbcDaoSupport implements IAccountDao {


    public List<Account> findAllCount() {
        return null;
    }

    public Account findAccountById(Integer accountId) {
        List<Account> query = getJdbcTemplate().query("select * from my where id = ?", new BeanPropertyRowMapper<Account>(Account.class), accountId);
        return query.isEmpty() ? null : query.get(0);

    }

    public void saveAccount(Account account) {

    }

    public void updateAccount(Account account) {
        getJdbcTemplate().update("update my set name = ?,money = ? where id = ?",account.getName(),account.getMoney(),account.getId());
    }

    public void deleteAccount(Integer accountId) {
    }

    public Account findAccountByName(String accountName) {
        List<Account> query = getJdbcTemplate().query("select * from my where name = ?", new BeanPropertyRowMapper<Account>(Account.class), accountName);
        if (query.isEmpty()) return null;
        if (query.size() > 1) throw new RuntimeException("不唯一");
        return query.get(0);
    }
}
