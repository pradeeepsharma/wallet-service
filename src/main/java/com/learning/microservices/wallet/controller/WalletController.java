package com.learning.microservices.wallet.controller;

import com.learning.microservices.wallet.domain.TransactionType;
import com.learning.microservices.wallet.modal.BalanceResponse;
import com.learning.microservices.wallet.modal.TransactionRequest;
import com.learning.microservices.wallet.modal.TransactionResponse;
import com.learning.microservices.wallet.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class WalletController {

    @Autowired
    WalletService walletService;

    @PostMapping("/wallet/{customerId}")
    public ResponseEntity<Boolean> getAllTransaction(@PathVariable Long customerId){
        Long walletId = walletService.createWallet(customerId);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @PostMapping("/wallet/action")
    public ResponseEntity<TransactionResponse> makeTransaction(@RequestBody TransactionRequest transactionRequest){
        TransactionResponse transactionResponse = walletService.makeTransaction(transactionRequest);
        return new ResponseEntity<>(transactionResponse, HttpStatus.CREATED);
    }



}
