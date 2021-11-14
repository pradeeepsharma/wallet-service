package com.learning.microservices.wallet.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class Wallet {
    private Long id;
    private Double balance;
    private List<Transaction> transactions;
}
