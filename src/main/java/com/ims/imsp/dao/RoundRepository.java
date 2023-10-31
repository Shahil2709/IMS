package com.ims.imsp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ims.imsp.entities.Round;

public interface RoundRepository extends JpaRepository<Round, Long> {
}