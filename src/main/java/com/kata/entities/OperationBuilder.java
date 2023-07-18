package com.kata.entities;

import java.time.LocalDateTime;

public class OperationBuilder {
    private OperationType type;
    private LocalDateTime operationDate;
    private Double amount;
    private String idAccount;

    public static OperationBuilder init() { return new OperationBuilder();}

    public OperationBuilder setType(OperationType type) {
        this.type = type;
        return this;
    }

    public OperationBuilder setOperationDate(LocalDateTime operationDate) {
        this.operationDate = operationDate;
        return this;
    }

    public OperationBuilder setAmount(Double amount) {
        this.amount = amount;
        return this;
    }

    public OperationBuilder setIdAccount(String idAccount) {
        this.idAccount = idAccount;
        return this;
    }

    public Operation build() {
        return new Operation(type, operationDate, amount, idAccount);
    }
}