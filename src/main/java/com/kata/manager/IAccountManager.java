package com.kata.manager;

import com.kata.entities.Account;
import com.kata.exceptions.InsufficientFunds;

public interface IAccountManager {

    Account deposit(String idAccount, Double amount);

    Account withdraw(String idAccount, Double amount) throws InsufficientFunds;

    Account consultAccount(String idAccount);

    Account create(Account account);
}
