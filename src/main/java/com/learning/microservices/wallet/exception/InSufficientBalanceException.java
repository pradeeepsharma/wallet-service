package com.learning.microservices.wallet.exception;

public class InSufficientBalanceException extends RuntimeException{
    public InSufficientBalanceException(String message){
        super(message);
    }

}
