package com.kata.repository;

import com.kata.entities.Operation;

import java.util.List;

public interface IOperationRepository {

    Operation save(Operation operation);

    List<Operation> getAllOperations(String idAccount);
}
