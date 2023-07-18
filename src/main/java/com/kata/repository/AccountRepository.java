package com.kata.repository;

import com.kata.entities.Account;

import java.util.HashMap;
import java.util.Map;

public class AccountRepository implements IAccountRepository {

    private static int SEQUENCE_ID;
    private Map<String, Account> accounts = new HashMap();

    @Override
    public Account create(Account account) {
        account.setId(String.valueOf(++SEQUENCE_ID));
        accounts.put(account.getId(), account);
        return account;
    }

    @Override
    public void update(Account account) {
        accounts.replace(account.getId(), account);
    }

    @Override
    public Account getAccount(String idAccount) {
        return accounts.get(idAccount);
    }
}
