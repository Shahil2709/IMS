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

import com.ims.imsp.entities.JobPosting;
import com.ims.imsp.services.JobPostingService;

@RestController
@RequestMapping("/ims/job-postings")
public class JobPostingController {
    @Autowired
    private JobPostingService jobPostingService;

    @PostMapping
    public ResponseEntity<JobPosting> createJobPosting(@RequestBody JobPosting jobPosting) {
        JobPosting createdJobPosting = jobPostingService.createJobPosting(jobPosting);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdJobPosting);
    }

    @GetMapping
    public ResponseEntity<List<JobPosting>> getAllJobPostings() {
        List<JobPosting> jobPostings = jobPostingService.getAllJobPostings();
        return ResponseEntity.ok(jobPostings);
    }

    @GetMapping("/{jobPostingId}")
    public ResponseEntity<JobPosting> getJobPostingById(@PathVariable Long jobPostingId) {
        JobPosting jobPosting = jobPostingService.getJobPostingById(jobPostingId);
        if (jobPosting == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(jobPosting);
    }

    @PutMapping("/{jobPostingId}")
    public ResponseEntity<JobPosting> updateJobPosting(
        @PathVariable Long jobPostingId,
        @RequestBody JobPosting updatedJobPosting
    ) {
        JobPosting jobPosting = jobPostingService.updateJobPosting(jobPostingId, updatedJobPosting);
        if (jobPosting == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(jobPosting);
    }

    @DeleteMapping("/{jobPostingId}")
    public ResponseEntity<Void> deleteJobPosting(@PathVariable Long jobPostingId) {
        jobPostingService.deleteJobPosting(jobPostingId);
        return ResponseEntity.noContent().build();
    }
}
