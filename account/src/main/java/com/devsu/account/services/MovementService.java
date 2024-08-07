package com.devsu.account.services;

import com.devsu.account.dao.AccountDao;
import com.devsu.account.dao.MovementDao;
import com.devsu.account.dto.MovementDTO;
import com.devsu.account.entities.Account;
import com.devsu.account.entities.Movement;
import com.devsu.account.utils.InsufficientBalanceException;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class MovementService {

    private final MovementDao movementDao;

    private final AccountDao accountDao;

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public MovementService(MovementDao movementDao, AccountDao accountDao) {
        this.movementDao = movementDao;
        this.accountDao = accountDao;
    }

    public List<MovementDTO> getAllMovements() {
        return movementDao.findAll().stream().map(x -> new MovementDTO(x.getId(), sdf.format(x.getDate()), x.getType() == MovementDTO.TYPE_WITHDRAW ? MovementDTO.WITHDRAW : MovementDTO.DEPOSIT, x.getValue(), x.getInitialBalance(), x.getCurrentBalance(), x.isStatus(), x.getAccountId())).toList();
    }

    public Movement getMovementById(int id) {
        return movementDao.findById(id);
    }

    public MovementDTO createMovement(MovementDTO dto) throws InsufficientBalanceException, ParseException {
        Account account = accountDao.findById(dto.getAccountId());
        if (account == null) {
            return null;
        }
        Movement lastMovement = movementDao.findLastMovementByAccountId(dto.getAccountId());
        int value = Math.abs(dto.getValue());
        int initialBalance = lastMovement != null ? lastMovement.getCurrentBalance() : account.getInitialBalance();
        if (dto.getValue() < 0 && initialBalance - value < 0) {
            throw new InsufficientBalanceException("Saldo no disponible");
        }
        int currentBalance = dto.getType() == MovementDTO.TYPE_WITHDRAW ? initialBalance - value : initialBalance + value;
        Movement movement = new Movement(sdf.parse(dto.getDate()), dto.getType(), value, initialBalance, currentBalance, dto.isStatus(), dto.getAccountId());
        movementDao.save(movement);
        return new MovementDTO(movement.getId(), sdf.format(movement.getDate()), movement.getType() == MovementDTO.TYPE_WITHDRAW ? MovementDTO.WITHDRAW : MovementDTO.DEPOSIT, movement.getValue(), movement.getInitialBalance(), movement.getCurrentBalance(), movement.isStatus(), movement.getAccountId());

    }

    public MovementDTO updateMovement(int id, MovementDTO movementDetails) throws InsufficientBalanceException, ParseException {

        Movement movement = movementDao.findById(id);
        if (movement == null) {
            return null;
        }
        Account account = accountDao.findById(movementDetails.getAccountId());
        if (account == null) {
            return null;
        }
        Movement lastMovement = movementDao.findLastMovementByAccountId(movementDetails.getAccountId());
        int value = Math.abs(movementDetails.getValue());
        int previous = lastMovement.getCurrentBalance();
        int balance = movement.getType() == MovementDTO.TYPE_WITHDRAW ? previous + movement.getValue() : previous - movement.getValue();
        if (movementDetails.getType() == MovementDTO.TYPE_WITHDRAW && balance - value < 0) {
            throw new InsufficientBalanceException("Saldo no disponible");
        }
        int currentBalance = movementDetails.getType() == MovementDTO.TYPE_WITHDRAW ? balance - value : balance + value;
        movement.setType(movementDetails.getType());
        movement.setValue(movementDetails.getValue());
        movement.setInitialBalance(movementDetails.getInitialBalance());
        movement.setCurrentBalance(currentBalance);
        movement.setAccountId(movement.getAccountId());
        movement.setStatus(movementDetails.isStatus());
        movementDao.save(movement);
        lastMovement.setCurrentBalance(currentBalance);
        movementDao.save(lastMovement);
        return new MovementDTO(movement.getId(), sdf.format(movement.getDate()), movement.getType() == MovementDTO.TYPE_WITHDRAW ? MovementDTO.WITHDRAW : MovementDTO.DEPOSIT, movement.getValue(), movement.getInitialBalance(), movement.getCurrentBalance(), movement.isStatus(), movement.getAccountId());

    }

    public void deleteMovement(int id) {
        Movement movement = movementDao.findById(id);
        if (movement == null) {
            return;
        }
        int count = movementDao.countMovementsByAccountId(movement.getAccountId());
        if (count > 1) {
            Movement lastMovement = movementDao.findLastMovementByAccountId(movement.getAccountId());
            if (lastMovement.getId() != id) {
                int previous = lastMovement.getCurrentBalance();
                int balance = movement.getType() == MovementDTO.TYPE_WITHDRAW ? previous + movement.getValue() : previous - movement.getValue();
                lastMovement.setCurrentBalance(balance);
                movementDao.save(lastMovement);
            }
        }
        movementDao.deleteById(id);
    }
}
