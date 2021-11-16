package com.learning.microservices.wallet.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Wallet {
    @Id
    @GeneratedValue
    private Long id;
    private Long customerId;
    private Double balance;
    @OneToMany(mappedBy = "wallet")
   /* @JoinTable(name = "wallet_transactions",
            joinColumns = {@JoinColumn(name = "id")},
            inverseJoinColumns = {@JoinColumn(name = "transaction_Id")}
    )*/
    private List<Transaction> transactions;
}
