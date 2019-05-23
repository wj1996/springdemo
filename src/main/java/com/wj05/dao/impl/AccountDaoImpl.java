package com.wj05.dao.impl;

import com.wj05.dao.interfaces.IAccountDao;
import org.springframework.stereotype.Repository;

@Repository("accountDao05")
public class AccountDaoImpl implements IAccountDao {

    public void saveAccount() {
        System.out.println("save Account");
    }
}
