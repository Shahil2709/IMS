package com.ims.imsp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ims.imsp.entities.JobPosting;



@Repository
public interface JobPostingRepository extends JpaRepository<JobPosting, Long> {
}

