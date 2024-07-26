package com.devsu.account.controllers;

import com.devsu.account.dto.MovementDTO;
import com.devsu.account.entities.Movement;
import com.devsu.account.services.MovementService;
import org.hibernate.query.ParameterLabelException;
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
    public ResponseEntity<MovementDTO> createMovement(@RequestBody MovementDTO movement) {
        MovementDTO result = movementService.createMovement(movement);
        return result != null ? ResponseEntity.ok(result) : ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovementDTO> updateMovement(@PathVariable int id, @RequestBody MovementDTO movementDetails) {
        MovementDTO movement = movementService.updateMovement(id,movementDetails);
        if (movement != null) {
            return ResponseEntity.ok(movement);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovement(@PathVariable int id) {
        movementService.deleteMovement(id);
        return ResponseEntity.noContent().build();

    }
}
