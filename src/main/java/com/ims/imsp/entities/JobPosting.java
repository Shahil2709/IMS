package com.ims.imsp.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JobPosting {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String description;
    private String department;
    private String skills;
    private String experienceLevel;
    private String location;
    private String salaryRange;
    private LocalDate applicationDeadline;
    private String responsibilities;
    private String requirements;
    private LocalDateTime publishedDate;
    private boolean filled;
  
}
