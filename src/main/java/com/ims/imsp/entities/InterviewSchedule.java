package com.ims.imsp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter @Setter
public class InterviewSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Interview interview;

    @OneToOne
    private Round round;

    @OneToOne
    private User interviewer;

    private LocalDate scheduledDate;
    private LocalTime scheduledTime;
    private String location;
    private String status;

}
