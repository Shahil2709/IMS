package com.ims.imsp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ims.imsp.entities.InterviewSchedule;
import com.ims.imsp.services.InterviewScheduleService;

@RestController
@RequestMapping("/ims/interview-schedules")
public class InterviewScheduleController {
    @Autowired
    private InterviewScheduleService interviewScheduleService;

    @PostMapping
    public ResponseEntity<InterviewSchedule> createInterviewSchedule(@RequestBody InterviewSchedule interviewSchedule) {
        InterviewSchedule createdInterviewSchedule = interviewScheduleService.createInterviewSchedule(interviewSchedule);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdInterviewSchedule);
    }

    @GetMapping
    public ResponseEntity<List<InterviewSchedule>> getAllInterviewSchedules() {
        List<InterviewSchedule> interviewSchedules = interviewScheduleService.getAllInterviewSchedules();
        return ResponseEntity.ok(interviewSchedules);
    }

    @GetMapping("/{scheduleId}")
    public ResponseEntity<InterviewSchedule> getInterviewScheduleById(@PathVariable Long scheduleId) {
        InterviewSchedule interviewSchedule = interviewScheduleService.getInterviewScheduleById(scheduleId);
        if (interviewSchedule == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(interviewSchedule);
    }

    @PutMapping("/{scheduleId}")
    public ResponseEntity<InterviewSchedule> updateInterviewSchedule(
        @PathVariable Long scheduleId,
        @RequestBody InterviewSchedule updatedInterviewSchedule
    ) {
        InterviewSchedule interviewSchedule = interviewScheduleService.updateInterviewSchedule(scheduleId, updatedInterviewSchedule);
        if (interviewSchedule == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(interviewSchedule);
    }

    @DeleteMapping("/{scheduleId}")
    public ResponseEntity<Void> deleteInterviewSchedule(@PathVariable Long scheduleId) {
        interviewScheduleService.deleteInterviewSchedule(scheduleId);
        return ResponseEntity.noContent().build();
    }
}
