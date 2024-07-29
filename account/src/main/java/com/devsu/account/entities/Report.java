package com.devsu.account.entities;

import java.util.Date;

public interface Report {
    Date getDate();

    String getClient();

    int getAccountNumber();

    int getAccountType();

    int getInitialBalance();

    boolean isStatus();

    int getAmount();

    int getCurrentBalance();

    int getMovementType();
}
