package com.kata.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Account {
    private String id;

    private Double balance;

    private LocalDate creationDate;

    private List<Operation> operations = new ArrayList<>();

    public Account() {
    }

    public Account(Double balance, LocalDate creationDate) {
        this.balance = balance;
        this.creationDate = creationDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }

    public void addOperation(Operation operation) {
        operations.add(operation);
    }
}
