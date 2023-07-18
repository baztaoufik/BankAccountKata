package com.kata.manager;

import com.kata.entities.Account;
import com.kata.entities.OperationType;
import com.kata.exceptions.InsufficientFunds;
import com.kata.repository.IAccountRepository;
import com.kata.repository.IOperationRepository;
import com.kata.repository.RepositoryFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AccountManagerTest {

    private IAccountRepository accountRepository = RepositoryFactory.createAccountRepository();

    private IOperationRepository operationRepository = RepositoryFactory.createOperationRepository();

    private IAccountManager accountManager;

    private Account account;

    @BeforeEach
    void setUp() {
        Double initialBalance = 100.0;
        LocalDate creationDate = LocalDate.now();
        account = accountRepository.create(new Account(initialBalance, creationDate));

        accountManager = new AccountManager(accountRepository, operationRepository);
    }

    @Test
    void deposit_ShouldAddAmountToBalance() {
        // Arrange
        Double amount = 50.0;
        Double initialBalance = account.getBalance();

        // when
        Account result = accountManager.deposit(account.getId(), amount);

        // Assert
        Account updatedAccount = accountRepository.getAccount(account.getId());

        assertEquals(initialBalance + amount, updatedAccount.getBalance());
        assertEquals(1, updatedAccount.getOperations().size());
        assertEquals(OperationType.DEPOSIT, updatedAccount.getOperations().get(0).getType());
        assertEquals(amount, updatedAccount.getOperations().get(0).getAmount());
        assertEquals(updatedAccount, result);
    }

    @Test
    void withdraw_shouldSubtractAmountFromTheBalance() throws InsufficientFunds {
        // Arrange
        Double amount = 50.0;
        Double initialBalance = account.getBalance();

        // when
        Account result = accountManager.withdraw(account.getId(), amount);

        // Assert
        Account updatedAccount = accountRepository.getAccount(account.getId());

        assertEquals(initialBalance - amount, updatedAccount.getBalance());
        assertEquals(1, updatedAccount.getOperations().size());
        assertEquals(OperationType.WITHDRAWAL, updatedAccount.getOperations().get(0).getType());
        assertEquals(amount, updatedAccount.getOperations().get(0).getAmount());
        assertEquals(updatedAccount, result);
    }

    @Test
    void consultAccount_shouldReturnAllOperationMadeOnTheAccount() throws InsufficientFunds {
        // Arrange
        Double depositAmount = 50.0;
        Double withdrawalAmount = 50.0;
        Double initialBalance = account.getBalance();

        // when
        accountManager.deposit(account.getId(), depositAmount);
        accountManager.withdraw(account.getId(), depositAmount);

        // Assert
        Account updatedAccount = accountRepository.getAccount(account.getId());

        assertEquals(initialBalance + depositAmount - withdrawalAmount, updatedAccount.getBalance());
        assertEquals(2, updatedAccount.getOperations().size());
        assertEquals(OperationType.DEPOSIT, updatedAccount.getOperations().get(0).getType());
        assertEquals(depositAmount, updatedAccount.getOperations().get(0).getAmount());
        assertEquals(OperationType.WITHDRAWAL, updatedAccount.getOperations().get(1).getType());
        assertEquals(withdrawalAmount, updatedAccount.getOperations().get(1).getAmount());
    }
}