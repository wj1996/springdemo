package com.wj06.service.interfaces;

import com.wj06.domain.Account;

import java.util.List;

public interface IAccountService {

    List<Account> findAllCount();

    Account findAccountById(Integer accountId);

    void saveAccount(Account account);

    void updateAccount(Account account);

    void deleteAccount(Integer accountId);



}
