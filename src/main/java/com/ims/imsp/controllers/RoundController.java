package com.ims.imsp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ims.imsp.entities.Round;
import com.ims.imsp.services.RoundService;

@RestController
@RequestMapping("/ims/rounds")
public class RoundController {

    @Autowired
    private RoundService roundService;

    @PostMapping
    public ResponseEntity<Round> createRound(@RequestBody Round round) {
        Round createdRound = roundService.createRound(round);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRound);
    }

    @GetMapping
    public ResponseEntity<List<Round>> getAllRounds() {
        List<Round> rounds = roundService.getAllRounds();
        return ResponseEntity.ok(rounds);
    }

    @GetMapping("/{roundId}")
    public ResponseEntity<Round> getRoundById(@PathVariable Long roundId) {
        Round round = roundService.getRoundById(roundId);
        if (round == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(round);
    }

    @PutMapping("/{roundId}")
    public ResponseEntity<Round> updateRound(@PathVariable Long roundId, @RequestBody Round updatedRound) {
        Round round = roundService.updateRound(roundId, updatedRound);
        if (round == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(round);
    }

    @DeleteMapping("/{roundId}")
    public ResponseEntity<Void> deleteRound(@PathVariable Long roundId) {
        roundService.deleteRound(roundId);
        return ResponseEntity.noContent().build();
    }
}
