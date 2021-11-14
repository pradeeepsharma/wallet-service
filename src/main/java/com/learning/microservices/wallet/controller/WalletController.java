package com.learning.microservices.wallet.controller;

import com.learning.microservices.wallet.modal.BalanceResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WalletController {
    @GetMapping("/balance/history")
    public ResponseEntity<BalanceResponse> getAllTransaction(){
        return null;
    }

    @PostMapping("/balance/credit/{amount}")
    public ResponseEntity<Object> creditBalance(){
        return null;
    }

    @PostMapping("/balance/debit/{amount}")
    public ResponseEntity<Object> debitBalance(){
        return null;
    }


}
