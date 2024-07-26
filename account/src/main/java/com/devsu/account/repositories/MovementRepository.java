package com.devsu.account.repositories;

import com.devsu.account.entities.Movement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovementRepository extends JpaRepository<Movement, Integer> {
}
