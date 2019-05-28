package com.wj13.dao.interfaces;

import com.wj13.domain.Account;

import java.util.List;

public interface IAccountDao {

    List<Account> findAllCount();

    Account findAccountById(Integer accountId);

    void saveAccount(Account account);

    void updateAccount(Account account);

    void deleteAccount(Integer accountId);

    Account findAccountByName(String accountName);


}
