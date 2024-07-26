package com.devsu.account.dao;

import com.devsu.account.entities.Movement;

import java.util.List;

public interface MovementDao {
    List<Movement> findAll();
    Movement findById(int id);
    Movement save(Movement movement);
    void deleteById(int id);
    Movement findLastMovementByAccountId(int accountId);
    int countMovementsByAccountId(int accountId);
}
