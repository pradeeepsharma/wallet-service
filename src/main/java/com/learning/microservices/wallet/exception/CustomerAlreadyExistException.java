package com.learning.microservices.wallet.exception;

public class CustomerAlreadyExistException extends RuntimeException {
    public CustomerAlreadyExistException(String message){
        super(message);
    }
}
