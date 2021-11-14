package com.learning.microservices.wallet.modal;

import com.learning.microservices.wallet.domain.Transaction;

import java.util.List;

public class BalanceResponse {
    private Long balance;
    private List<Transaction> transactions;
}
