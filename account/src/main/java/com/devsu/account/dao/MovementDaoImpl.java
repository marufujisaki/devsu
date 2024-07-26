package com.devsu.account.dao;

import com.devsu.account.entities.Movement;
import com.devsu.account.repositories.MovementRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovementDaoImpl implements MovementDao {
    private final MovementRepository movementRepository;

    public MovementDaoImpl(MovementRepository movementRepository) {
        this.movementRepository = movementRepository;
    }

    @Override
    public List<Movement> findAll() {
        return movementRepository.findAll();
    }

    @Override
    public Movement findById(int id) {
        return movementRepository.findById(id).orElse(null);
    }

    @Override
    public Movement save(Movement movement) {
        return movementRepository.save(movement);
    }

    @Override
    public void deleteById(int id) {
        movementRepository.deleteById(id);
    }
}
