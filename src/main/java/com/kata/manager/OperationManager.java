package com.kata.manager;

import com.kata.entities.Operation;
import com.kata.repository.IOperationRepository;
import com.kata.repository.RepositoryFactory;

import java.util.List;

public class OperationManager implements IOperationManager{
    private IOperationRepository operationRepository = RepositoryFactory.createOperationRepository();

    @Override
    public List<Operation> getAllOperations(String idAccount) {
        return operationRepository.getAllOperations(idAccount);
    }
}
