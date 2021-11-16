package com.learning.microservices.wallet.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Transaction {
    @Id
    @GeneratedValue
    private Long transactionId;
    private double amount;
    private TransactionType transactionType;
    private Date date;
    @ManyToOne
    @JoinColumn(name = "wallet_id")
    private Wallet wallet;

}
