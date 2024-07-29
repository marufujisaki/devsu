package com.devsu.account.dao;

import com.devsu.account.entities.Movement;
import com.devsu.account.entities.Report;

import java.util.Date;
import java.util.List;

public interface MovementDao {
    List<Movement> findAll();
    Movement findById(int id);
    Movement save(Movement movement);
    void deleteById(int id);
    Movement findLastMovementByAccountId(int accountId);
    int countMovementsByAccountId(int accountId);
    List<Report> getReport(String from, String to, int clientId);
}
