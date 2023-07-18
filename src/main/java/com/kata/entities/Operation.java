package com.kata.entities;

import java.time.LocalDateTime;

public class Operation {
    private String id;

    private OperationType type;

    private LocalDateTime operationDate;

    private Double amount;

    private String idAccount;

    public Operation(OperationType type, LocalDateTime operationDate, Double amount, String idAccount) {
        this.type = type;
        this.operationDate = operationDate;
        this.amount = amount;
        this.idAccount = idAccount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public OperationType getType() {
        return type;
    }

    public void setType(OperationType type) {
        this.type = type;
    }

    public LocalDateTime getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(LocalDateTime operationDate) {
        this.operationDate = operationDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(String idAccount) {
        this.idAccount = idAccount;
    }
}
