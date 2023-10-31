package com.ims.imsp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ims.imsp.dao.InterviewerRepository;
import com.ims.imsp.entities.Interviewer;

@Service
public class InterviewerService {
    @Autowired
    private InterviewerRepository interviewerRepository;

    public Interviewer createInterviewer(Interviewer interviewer) {
        return interviewerRepository.save(interviewer);
    }

    public List<Interviewer> getAllInterviewers() {
        return interviewerRepository.findAll();
    }

    public Interviewer getInterviewerById(Long interviewerId) {
        return interviewerRepository.findById(interviewerId).orElse(null);
    }

    public Interviewer updateInterviewer(Long interviewerId, Interviewer updatedInterviewer) {
        Interviewer interviewer = interviewerRepository.findById(interviewerId).orElse(null);
        if (interviewer == null) {
            return null;
        }
        interviewer.setName(updatedInterviewer.getName());
        interviewer.setEmail(updatedInterviewer.getEmail());
        interviewer.setPhone(updatedInterviewer.getPhone());
        return interviewerRepository.save(interviewer);
    }

    public void deleteInterviewer(Long interviewerId) {
        interviewerRepository.deleteById(interviewerId);
    }
}
