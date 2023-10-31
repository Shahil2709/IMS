package com.ims.imsp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ims.imsp.entities.Interview;

public interface InterviewRepository extends JpaRepository<Interview, Long> {
}
