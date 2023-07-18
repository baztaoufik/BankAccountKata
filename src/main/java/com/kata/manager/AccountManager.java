package com.kata.manager;

import com.kata.entities.Account;
import com.kata.entities.Operation;
import com.kata.entities.OperationBuilder;
import com.kata.entities.OperationType;
import com.kata.exceptions.InsufficientFunds;
import com.kata.repository.IAccountRepository;
import com.kata.repository.IOperationRepository;
import com.kata.repository.RepositoryFactory;

import java.time.LocalDateTime;

public class AccountManager implements IAccountManager {

    private IAccountRepository accountRepository;

    private IOperationRepository operationRepository;

    public AccountManager(IAccountRepository accountRepository, IOperationRepository operationRepository) {
        this.accountRepository = accountRepository;
        this.operationRepository = operationRepository;
    }

    @Override
    public Account deposit(String idAccount, Double amount) {
        Operation depositOperation = OperationBuilder.init()
                    .setOperationDate(LocalDateTime.now())
                    .setIdAccount(idAccount)
                    .setType(OperationType.DEPOSIT)
                    .setAmount(amount)
                    .build();

        Account account = accountRepository.getAccount(idAccount);
        Double newBalance = account.getBalance() + amount;

        depositOperation = operationRepository.save(depositOperation);

        account.addOperation(depositOperation);
        account.setBalance(newBalance);

        accountRepository.update(account);
        return account;
    }

    @Override
    public Account withdraw(String idAccount, Double amount) throws InsufficientFunds {

        Account account = accountRepository.getAccount(idAccount);
        if (account.getBalance() < amount) {
            throw new InsufficientFunds("Insufficient funds");
        }

        Operation withdrawOperation = OperationBuilder.init()
                .setOperationDate(LocalDateTime.now())
                .setIdAccount(idAccount)
                .setType(OperationType.WITHDRAWAL)
                .setAmount(amount)
                .build();

        Double newBalance = account.getBalance() - amount;

        withdrawOperation = operationRepository.save(withdrawOperation);
        account.addOperation(withdrawOperation);
        account.setBalance(newBalance);
        accountRepository.update(account);
        return account;
    }

    @Override
    public Account consultAccount(String idAccount) {
        return accountRepository.getAccount(idAccount);
    }

    @Override
    public Account create(Account account) {
        return accountRepository.create(account);
    }


}
