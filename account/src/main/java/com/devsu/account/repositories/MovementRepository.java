package com.devsu.account.repositories;

import com.devsu.account.entities.Movement;
import com.devsu.account.entities.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface MovementRepository extends JpaRepository<Movement, Integer> {

    @Query(value = "SELECT * FROM Movement m WHERE m.account_id = :accountId ORDER BY m.date DESC LIMIT 1", nativeQuery = true)
    Movement findLastMovementByAccountId(int accountId);

    int countMovementsByAccountId(int accountId);

    @Query(value = "SELECT " +
            "    m.date AS date," +
            "    p.name AS client," +
            "    ac.account_number AS accountNumber, " +
            "    ac.type AS accountType, " +
            "    m.initial_balance AS initialBalance, " +
            "    m.status AS status, " +
            "    m.value AS amount, " +
            "    m.type AS movementType, " +
            "    m.current_balance AS currentBalance " +
            "FROM " +
            "    devsu.movement m " +
            "INNER JOIN " +
            "    devsu.account ac ON ac.account_id = m.account_id " +
            "INNER JOIN " +
            "    devsu.client c ON ac.client_id = c.client_id " +
            "INNER JOIN " +
            "    devsu.person p ON c.person_id = p.person_id " +
            "WHERE " +
            "    m.date >= :from " +
            "    AND m.date <= :to " +
            "    AND c.client_id = :clientId " +
            "ORDER BY m.date DESC", nativeQuery = true)
    List<Report> getReport(@Param("from") String from, @Param("to") String to, @Param("clientId") int clientId);

}
