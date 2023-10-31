package com.ims.imsp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ims.imsp.dao.ApplicationRepository;
import com.ims.imsp.entities.Application;

@Service
public class ApplicationService {
    @Autowired
    private ApplicationRepository applicationRepository;

    public Application createApplication(Application application) {
        return applicationRepository.save(application);
    }

    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }

    public Application getApplicationById(Long applicationId) {
        return applicationRepository.findById(applicationId).orElse(null);
    }

    public Application updateApplication(Long applicationId, Application updatedApplication) {
        Application application = applicationRepository.findById(applicationId).orElse(null);
        if (application == null) {
            return null;
        }
        application.setJobPosting(updatedApplication.getJobPosting());
        application.setCandidate(updatedApplication.getCandidate());
        application.setStatus(updatedApplication.getStatus());
        application.setSubmissionDate(updatedApplication.getSubmissionDate());
        application.setCoverLetterText(updatedApplication.getCoverLetterText());
        application.setStatusDate(updatedApplication.getStatusDate());
        return applicationRepository.save(application);
    }

    public void deleteApplication(Long applicationId) {
        applicationRepository.deleteById(applicationId);
    }
}
