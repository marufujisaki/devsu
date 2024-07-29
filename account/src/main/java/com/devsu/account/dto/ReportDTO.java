package com.devsu.account.dto;

import java.io.Serializable;

public class ReportDTO implements Serializable {
    private String date;
    private String client;
    private int accountNumber;
    private String accountType;
    private int initialBalance;
    private boolean status;
    private int amount;
    private int currentBalance;

    public ReportDTO() {
        // empty constructor
    }

    public ReportDTO(String date, String client, int accountNumber, String accountType, int initialBalance, boolean status, int amount, int currentBalance) {
        this.date = date;
        this.client = client;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.initialBalance = initialBalance;
        this.status = status;
        this.amount = amount;
        this.currentBalance = currentBalance;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public int getInitialBalance() {
        return initialBalance;
    }

    public void setInitialBalance(int initialBalance) {
        this.initialBalance = initialBalance;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(int currentBalance) {
        this.currentBalance = currentBalance;
    }
}
