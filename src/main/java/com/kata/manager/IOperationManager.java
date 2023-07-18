package com.kata.manager;

import com.kata.entities.Operation;

import java.util.List;

public interface IOperationManager {

    List<Operation> getAllOperations(String idAccount);

}
