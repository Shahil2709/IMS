package com.ims.imsp.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ims.imsp.dao.JobPostingRepository;
import com.ims.imsp.entities.JobPosting;

@Service
public class JobPostingService {
    @Autowired
    private JobPostingRepository jobPostingRepository;

    public JobPosting createJobPosting(JobPosting jobPosting) {
        return jobPostingRepository.save(jobPosting);
    }

    public List<JobPosting> getAllJobPostings() {
        return jobPostingRepository.findAll();
    }

    public JobPosting getJobPostingById(Long jobPostingId) {
        return jobPostingRepository.findById(jobPostingId).orElse(null);
    }

    public JobPosting updateJobPosting(Long jobPostingId, JobPosting updatedJobPosting) {
        JobPosting jobPosting = jobPostingRepository.findById(jobPostingId).orElse(null);
        if (jobPosting == null) {
            return null;
        }
        jobPosting.setTitle(updatedJobPosting.getTitle());
        jobPosting.setDescription(updatedJobPosting.getDescription());
        jobPosting.setDepartment(updatedJobPosting.getDepartment());
        jobPosting.setSkills(updatedJobPosting.getSkills());
        jobPosting.setExperienceLevel(updatedJobPosting.getExperienceLevel());
        jobPosting.setLocation(updatedJobPosting.getLocation());
        jobPosting.setSalaryRange(updatedJobPosting.getSalaryRange());
        jobPosting.setApplicationDeadline(updatedJobPosting.getApplicationDeadline());
        jobPosting.setResponsibilities(updatedJobPosting.getResponsibilities());
        jobPosting.setRequirements(updatedJobPosting.getRequirements());
        jobPosting.setPublishedDate(updatedJobPosting.getPublishedDate());
        jobPosting.setFilled(updatedJobPosting.isFilled());
        return jobPostingRepository.save(jobPosting);
    }

    public void deleteJobPosting(Long jobPostingId) {
        jobPostingRepository.deleteById(jobPostingId);
    }
}
