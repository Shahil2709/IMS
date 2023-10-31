package com.ims.imsp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ims.imsp.entities.Interviewer;

public interface InterviewerRepository extends JpaRepository<Interviewer, Long> {
}
