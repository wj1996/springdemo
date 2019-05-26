package com.wj07.service.interfaces;

import com.wj07.domain.Account;

import java.util.List;

public interface IAccountService {

    List<Account> findAllAccount();

    Account findAccountById(Integer accountId);

    void saveAccount(Account account);

    void updateAccount(Account account);

    void deleteAccount(Integer accountId);



}
