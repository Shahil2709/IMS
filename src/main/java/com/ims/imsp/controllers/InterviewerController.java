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

import com.ims.imsp.entities.Interviewer;
import com.ims.imsp.services.InterviewerService;

@RestController
@RequestMapping("/ims/interviewers")
public class InterviewerController {
    @Autowired
    private InterviewerService interviewerService;

    @PostMapping
    public ResponseEntity<Interviewer> createInterviewer(@RequestBody Interviewer interviewer) {
        Interviewer createdInterviewer = interviewerService.createInterviewer(interviewer);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdInterviewer);
    }

    @GetMapping
    public ResponseEntity<List<Interviewer>> getAllInterviewers() {
        List<Interviewer> interviewers = interviewerService.getAllInterviewers();
        return ResponseEntity.ok(interviewers);
    }

    @GetMapping("/{interviewerId}")
    public ResponseEntity<Interviewer> getInterviewerById(@PathVariable Long interviewerId) {
        Interviewer interviewer = interviewerService.getInterviewerById(interviewerId);
        if (interviewer == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(interviewer);
    }

    @PutMapping("/{interviewerId}")
    public ResponseEntity<Interviewer> updateInterviewer(
        @PathVariable Long interviewerId,
        @RequestBody Interviewer updatedInterviewer
    ) {
        Interviewer interviewer = interviewerService.updateInterviewer(interviewerId, updatedInterviewer);
        if (interviewer == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(interviewer);
    }

    @DeleteMapping("/{interviewerId}")
    public ResponseEntity<Void> deleteInterviewer(@PathVariable Long interviewerId) {
        interviewerService.deleteInterviewer(interviewerId);
        return ResponseEntity.noContent().build();
    }
}