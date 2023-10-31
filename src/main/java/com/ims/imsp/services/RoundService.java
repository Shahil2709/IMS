package com.ims.imsp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ims.imsp.dao.RoundRepository;
import com.ims.imsp.entities.Round;

@Service
public class RoundService {
    @Autowired
    private RoundRepository roundRepository;

    public Round createRound(Round round) {
        return roundRepository.save(round);
    }

    public List<Round> getAllRounds() {
        return roundRepository.findAll();
    }

    public Round getRoundById(Long roundId) {
        return roundRepository.findById(roundId).orElse(null);
    }

    public Round updateRound(Long roundId, Round updatedRound) {
        Round round = roundRepository.findById(roundId).orElse(null);
        if (round == null) {
            return null;
        }
        round.setRoundNumber(updatedRound.getRoundNumber());
        round.setName(updatedRound.getName());
        round.setDescription(updatedRound.getDescription());
        return roundRepository.save(round);
    }

    public void deleteRound(Long roundId) {
        roundRepository.deleteById(roundId);
    }
}
