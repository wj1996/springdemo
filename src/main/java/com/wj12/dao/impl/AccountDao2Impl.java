package com.wj12.dao.impl;

import com.wj12.dao.interfaces.IAccountDao;
import com.wj12.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

public class AccountDao2Impl extends JdbcDaoSupport implements IAccountDao {


    /**
     * 下面的使用JdbcTemplate的代码时都需要有的（每写一个dao），进行优化，使用父类的方法
     */

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
    }

    public void deleteAccount(Integer accountId) {
    }

    public Account findAccountByName(String accountName) {
        return null;
    }
}
