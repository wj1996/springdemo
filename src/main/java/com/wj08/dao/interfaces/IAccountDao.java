package com.wj08.dao.interfaces;

import com.wj08.domain.Account;

import java.util.List;

public interface IAccountDao {

    List<Account> findAllCount();

    Account findAccountById(Integer accountId);

    void saveAccount(Account account);

    void updateAccount(Account account);

    void deleteAccount(Integer accountId);
}
