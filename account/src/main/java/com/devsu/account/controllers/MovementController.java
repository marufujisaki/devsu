package com.devsu.account.controllers;

import com.devsu.account.dto.MovementDTO;
import com.devsu.account.entities.Movement;
import com.devsu.account.services.MovementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movimientos")
public class MovementController {

    private final MovementService movementService;

    public MovementController(MovementService movementService) {
        this.movementService = movementService;
    }

    @GetMapping
    public List<Movement> getAllMovements() {
        return movementService.getAllMovements();
    }

    @PostMapping
    public Movement createMovement(@RequestBody MovementDTO movement) {
        return movementService.createMovement(movement);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movement> updateMovement(@PathVariable int id, @RequestBody MovementDTO movementDetails) {
        Movement movement = movementService.updateMovement(id,movementDetails);
        if (movement != null) {
            return ResponseEntity.ok(movement);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovement(@PathVariable int id) {
        movementService.deleteMovement(id);
        return ResponseEntity.noContent().build();

    }
}
