package com.learning.microservices.wallet.service;

import com.learning.microservices.wallet.domain.Transaction;
import com.learning.microservices.wallet.domain.TransactionStatus;
import com.learning.microservices.wallet.domain.TransactionType;
import com.learning.microservices.wallet.domain.Wallet;
import com.learning.microservices.wallet.exception.InSufficientBalanceException;
import com.learning.microservices.wallet.modal.TransactionRequest;
import com.learning.microservices.wallet.modal.TransactionResponse;
import com.learning.microservices.wallet.repository.TransactionRepository;
import com.learning.microservices.wallet.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

import static java.util.Objects.nonNull;

@Service
public class WalletService {
    @Autowired
    private WalletRepository repository;
    @Autowired
    private TransactionRepository transactionRepository;

    @Transactional
    public TransactionResponse makeTransaction(TransactionRequest transactionRequest) {
        Wallet wallet = repository.findByCustomerId(transactionRequest.getCustomerId());
        if (transactionRequest.getTransactionType().equals(TransactionType.DEBIT)
                && wallet.getBalance() < transactionRequest.getAmount()) {
            throw new InSufficientBalanceException("Unable to debit amount as balance is " + wallet.getBalance());
        } else if (transactionRequest.getTransactionType().equals(TransactionType.DEBIT)
                && wallet.getBalance() >= transactionRequest.getAmount()) {
            wallet.setBalance(Double.sum(wallet.getBalance() ,(0-transactionRequest.getAmount())));
        }
        if (transactionRequest.getTransactionType().equals(TransactionType.CREDIT))

            wallet.setBalance(Double.sum(wallet.getBalance() ,transactionRequest.getAmount()));
        repository.save(wallet);

        Transaction transaction = Transaction.builder()
                .transactionType(transactionRequest.getTransactionType())
                .amount(transactionRequest.getAmount())
                .date(new Date())
                .wallet(wallet)
                .build();
        Transaction savedTransaction = transactionRepository.save(transaction);
        TransactionResponse response = new TransactionResponse();
        response.setUpdatedBalance(wallet.getBalance());
        response.setStatus(nonNull(savedTransaction) ? TransactionStatus.SUCCESS : TransactionStatus.FAIL);
        return response;
    }

    public Long createWallet(Long customerId) {
        Wallet wallet = Wallet.builder().customerId(customerId).balance(0.0).build();
        return repository.save(wallet).getId();
    }
}
