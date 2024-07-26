package com.devsu.account.entities;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name= "account")
public class Account implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    public static final int TYPE_AHORRO = 0;
    public static final int TYPE_CORRIENTE = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="account_id")
    private int id;

    @Column(name = "account_number")
    private int accountNumber;

    @Column(name = "type")
    private int type;

    @Column(name = "initial_balance")
    private int initialBalance;

    @Column(name = "status")
    private boolean status;

    @Column(name = "client_id")
    private int clientId;

    public Account() {}

    public Account(int accountNumber, int type, int initialBalance, boolean status, int clientId) {}

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
        return type;
    }

    public void setType(int type) {
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
