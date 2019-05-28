package com.wj14.dao.impl;

import com.wj14.dao.interfaces.IAccountDao;
import com.wj14.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 集成spring的或者集成自己写的（自己写的方便进行注解开发）
 */
@Repository("accountDao14")
public class AccountDaoImpl implements IAccountDao {

    @Autowired
    @Qualifier("jdbcTemplate2")
    private JdbcTemplate jdbcTemplate;

    public List<Account> findAllCount() {
        return null;
    }

    public Account findAccountById(Integer accountId) {
        List<Account> query = jdbcTemplate.query("select * from my where id = ?", new BeanPropertyRowMapper<Account>(Account.class), accountId);
        return query.isEmpty() ? null : query.get(0);

    }

    public void saveAccount(Account account) {

    }

    public void updateAccount(Account account) {
        jdbcTemplate.update("update my set name = ?,money = ? where id = ?",account.getName(),account.getMoney(),account.getId());
    }

    public void deleteAccount(Integer accountId) {
    }

    public Account findAccountByName(String accountName) {
        List<Account> query = jdbcTemplate.query("select * from my where name = ?", new BeanPropertyRowMapper<Account>(Account.class), accountName);
        if (query.isEmpty()) return null;
        if (query.size() > 1) throw new RuntimeException("不唯一");
        return query.get(0);
    }
}
