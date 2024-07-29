package com.devsu.account.utils;

public class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String text){
        super(text);
    }
}
