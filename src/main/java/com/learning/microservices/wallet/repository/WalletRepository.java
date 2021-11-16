package com.learning.microservices.wallet.repository;

import com.learning.microservices.wallet.domain.Wallet;
import org.springframework.data.repository.CrudRepository;

public interface WalletRepository extends CrudRepository<Wallet,Long > {
    Wallet findByCustomerId(Long customerId);
}
