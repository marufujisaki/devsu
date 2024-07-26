package com.devsu.account.entities;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "movement")
public class Movement implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    public static final int TYPE_WITHDRAW = 0;
    public static final int TYPE_DEPOSIT = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movement_id")
    private int id;

    @Column(name = "date")
    private Date date;

    @Column(name = "type")
    private int type;

    @Column(name = "value")
    private int value;

    @Column(name = "initial_balance")
    private int initialBalance;

    @Column(name = "current_balance")
    private int currentBalance;

    @Column(name = "status")
    private boolean status;

    @Column(name = "account_id")
    private int accountId;

    public Movement() {
        // empty constructor
    }
    public Movement(Date date, int type, int value, int initialBalance, int currentBalance, boolean status, int accountId) {}

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
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
