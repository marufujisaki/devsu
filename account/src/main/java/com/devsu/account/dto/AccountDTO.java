package com.devsu.account.dto;

import jakarta.validation.constraints.NotNull;

public class AccountDTO {
    public static final int TYPE_AHORRO     = 0;
    public static final int TYPE_CORRIENTE  = 1;
    public static final String AHORRO = "Ahorro";
    public static final String CORRIENTE = "Corriente";

    private int id;
    @NotNull
    private int accountNumber;
    @NotNull
    private String type;
    @NotNull
    private int initialBalance;
    @NotNull
    private boolean status;
    @NotNull
    private int clientId;

    public AccountDTO(int id, int accountNumber, String type, int initialBalance, boolean status, int clientId) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.type = type;
        this.initialBalance = initialBalance;
        this.status = status;
        this.clientId = clientId;
    }

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
        return type.equals(AHORRO) ? TYPE_AHORRO : TYPE_CORRIENTE;
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
