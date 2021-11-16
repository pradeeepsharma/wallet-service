package com.learning.microservices.wallet.modal;

import com.learning.microservices.wallet.domain.TransactionType;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class TransactionRequest {
    private Long customerId;
    private double amount;
    private TransactionType transactionType;
}
