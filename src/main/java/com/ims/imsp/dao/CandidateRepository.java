package com.ims.imsp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ims.imsp.entities.Candidate;


@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {
}
