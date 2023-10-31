package com.ims.imsp.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ims.imsp.dao.CandidateRepository;
import com.ims.imsp.entities.Candidate;

@Service
public class CandidateService {
    @Autowired
    private CandidateRepository candidateRepository;

    public Candidate createCandidate(Candidate candidate) {
        return candidateRepository.save(candidate);
    }

    public List<Candidate> getAllCandidates() {
        return candidateRepository.findAll();
    }

    public Candidate getCandidateById(Long candidateId) {
        return candidateRepository.findById(candidateId).orElse(null);
    }

    public Candidate updateCandidate(Long candidateId, Candidate updatedCandidate) {
        Candidate candidate = candidateRepository.findById(candidateId).orElse(null);
        if (candidate == null) {
            return null;
        }
        candidate.setName(updatedCandidate.getName());
        candidate.setEmail(updatedCandidate.getEmail());
        candidate.setPhone(updatedCandidate.getPhone());
        candidate.setResume(updatedCandidate.getResume());
        candidate.setCoverLetter(updatedCandidate.getCoverLetter());
        candidate.setDateOfBirth(updatedCandidate.getDateOfBirth());
        candidate.setGender(updatedCandidate.getGender());
        candidate.setEducation(updatedCandidate.getEducation());
        candidate.setExperience(updatedCandidate.getExperience());
        return candidateRepository.save(candidate);
    }

    public void deleteCandidate(Long candidateId) {
        candidateRepository.deleteById(candidateId);
    }
}
