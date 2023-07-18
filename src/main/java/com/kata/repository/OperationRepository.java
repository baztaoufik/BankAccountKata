package com.kata.repository;

import com.kata.entities.Operation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OperationRepository implements IOperationRepository {

    private static int SEQUENCE_ID;
    private Map<String, Operation> operationsAccount = new HashMap<>();

    @Override
    public Operation save(Operation operation) {
        operation.setId(String.valueOf(++SEQUENCE_ID));
        operationsAccount.put(operation.getId(), operation);
        return operation;
    }

    @Override
    public List<Operation> getAllOperations(String idAccount) {
        return operationsAccount.values()
                .stream()
                .filter(account -> account.getIdAccount().equals(idAccount))
                .collect(Collectors.toList());
    }
}
