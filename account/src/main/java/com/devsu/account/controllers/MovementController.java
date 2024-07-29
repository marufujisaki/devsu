package com.devsu.account.controllers;

import com.devsu.account.dto.MovementDTO;
import com.devsu.account.entities.Movement;
import com.devsu.account.services.MovementService;
import com.devsu.account.utils.InsufficientBalanceException;
import org.hibernate.query.ParameterLabelException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("movimientos")
public class MovementController {

    private final MovementService movementService;

    public MovementController(MovementService movementService) {
        this.movementService = movementService;
    }

    @GetMapping
    public List<MovementDTO> getAllMovements() {
        return movementService.getAllMovements();
    }

    @PostMapping
    public ResponseEntity<String> createMovement(@RequestBody MovementDTO movement) {
        try {
            MovementDTO result = movementService.createMovement(movement);
            return result != null ? ResponseEntity.ok().build() : ResponseEntity.badRequest().build();
        } catch (InsufficientBalanceException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        } catch (ParseException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateMovement(@PathVariable int id, @RequestBody MovementDTO movementDetails) {
        try {
            MovementDTO movement = movementService.updateMovement(id, movementDetails);
            return movement != null ? ResponseEntity.ok().build() : ResponseEntity.badRequest().build();
        } catch (InsufficientBalanceException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        } catch (ParseException e) {
            return ResponseEntity.badRequest().build();
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovement(@PathVariable int id) {
        movementService.deleteMovement(id);
        return ResponseEntity.noContent().build();

    }
}
