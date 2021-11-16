package com.learning.microservices.wallet.domain;

public enum TransactionType {
    DEBIT("DEBIT"), CREDIT("CREDIT");
    private String value;
    private TransactionType(String value){
        this.value = value;
    }

}
