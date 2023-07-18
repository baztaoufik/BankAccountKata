package com.kata.repository;

import com.kata.entities.Account;

public interface IAccountRepository {

    Account create(Account account);

    void update(Account account);

    Account getAccount(String idAccount);
}
