package com.learning.microservices.wallet.repository;

import com.learning.microservices.wallet.domain.Transaction;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {
}
