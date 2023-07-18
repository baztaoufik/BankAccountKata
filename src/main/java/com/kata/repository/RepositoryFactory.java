package com.kata.repository;

public class RepositoryFactory {
    public static IOperationRepository createOperationRepository() {
        return new OperationRepository();
    }

    public static IAccountRepository createAccountRepository() {
        return new AccountRepository();
    }
}
