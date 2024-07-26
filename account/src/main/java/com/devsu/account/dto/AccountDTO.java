package com.devsu.account.dto;

public class AccountDTO {
    public static final int TYPE_AHORRO = 0;
    public static final int TYPE_CORRIENTE = 1;

    private int id;
    private int accountNumber;
    private String type;
    private int initialBalance;
    private boolean status;
    private int clientId;

    public int getId() {
        return id;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getType() {
        return type.equals("Ahorro") ? TYPE_AHORRO : TYPE_CORRIENTE;
    }

    public void setType(String type) {
        this.type = type;
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

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }
}
