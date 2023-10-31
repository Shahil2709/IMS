package com.ims.imsp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ims.imsp.entities.InterviewSchedule;

public interface InterviewScheduleRepository extends JpaRepository<InterviewSchedule, Long> {
}