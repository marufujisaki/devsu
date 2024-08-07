package com.devsu.account.dto;

import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

public class MovementDTO implements Serializable {

    public static final int TYPE_WITHDRAW = 0;
    public static final int TYPE_DEPOSIT = 1;
    public static final String DEPOSIT = "Deposito";
    public static final String WITHDRAW = "Retiro";

    private final int id;
    @NotNull
    private String date;
    @NotNull
    private String type;
    @NotNull
    private int value;
    private int initialBalance;
    private int currentBalance;
    @NotNull
    private boolean status;
    @NotNull
    private int accountId;

    public MovementDTO(int id, String date, String type, int value, int initialBalance, int currentBalance, boolean status, int accountId) {
        this.id = id;
        this.date = date;
        this.type = type;
        this.value = value;
        this.initialBalance = initialBalance;
        this.currentBalance = currentBalance;
        this.status = status;
        this.accountId = accountId;
    }

    public int getId() {
        return id;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getType() {
        return type.equals(DEPOSIT) ? TYPE_DEPOSIT : TYPE_WITHDRAW;
    }

    public void setType(int type) {
        this.type = type == TYPE_WITHDRAW ? WITHDRAW : DEPOSIT;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getInitialBalance() {
        return initialBalance;
    }

    public void setInitialBalance(int initialBalance) {
        this.initialBalance = initialBalance;
    }

    public int getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(int currentBalance) {
        this.currentBalance = currentBalance;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }
}
