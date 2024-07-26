package com.devsu.account.services;

import com.devsu.account.dao.MovementDao;
import com.devsu.account.dto.MovementDTO;
import com.devsu.account.entities.Movement;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovementService {

    private final MovementDao movementDao;

    public MovementService(MovementDao movementDao) {
        this.movementDao = movementDao;
    }

    public List<Movement> getAllMovements() {
        return movementDao.findAll();
    }

    public Movement getMovementById(int id) {
        return movementDao.findById(id);
    }

    public Movement createMovement(MovementDTO dto) {
        Movement movement = new Movement(dto.getDate(),dto.getType(),dto.getValue(),dto.getInitialBalance(),dto.getCurrentBalance(),dto.isStatus(),dto.getAccountId());
        return movementDao.save(movement);
    }

    public Movement updateMovement(int id, MovementDTO movementDetails) {
        Movement movement = movementDao.findById(id);
        if (movement != null) {
            movement.setDate(movementDetails.getDate());
            movement.setType(movementDetails.getType());
            movement.setValue(movementDetails.getValue());
            movement.setInitialBalance(movementDetails.getInitialBalance());
            movement.setCurrentBalance(movementDetails.getCurrentBalance());
            movement.setAccountId(movement.getAccountId());
            movement.setStatus(movementDetails.isStatus());
            return movementDao.save(movement);
        } else {
            return null;
        }
    }

    public void deleteMovement(int id) {
        movementDao.deleteById(id);
    }
}
