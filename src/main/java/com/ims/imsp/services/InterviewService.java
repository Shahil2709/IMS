package com.ims.imsp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ims.imsp.dao.InterviewRepository;
import com.ims.imsp.entities.Interview;

@Service
public class InterviewService {
    
    @Autowired
    private InterviewRepository interviewRepository;

    public Interview createInterview(Interview interview) {
        return interviewRepository.save(interview);
    }

    public List<Interview> getAllInterviews() {
        return interviewRepository.findAll();
    }

    public Interview getInterviewById(Long interviewId) {
        return interviewRepository.findById(interviewId).orElse(null);
    }

    public Interview updateInterview(Long interviewId, Interview updatedInterview) {
        Interview interview = interviewRepository.findById(interviewId).orElse(null);
        if (interview == null) {
            return null;
        }
        interview.setJobPosting(updatedInterview.getJobPosting());
        interview.setCandidate(updatedInterview.getCandidate());
        interview.setRoundNumber(updatedInterview.getRoundNumber());
        interview.setInterviewers(updatedInterview.getInterviewers());
        interview.setScheduledDate(updatedInterview.getScheduledDate());
        interview.setScheduledTime(updatedInterview.getScheduledTime());
        interview.setLocation(updatedInterview.getLocation());
        interview.setStatus(updatedInterview.getStatus());
        interview.setRound1Feedback(updatedInterview.getRound1Feedback());
        interview.setRound1Rating(updatedInterview.getRound1Rating());
        interview.setRound2Feedback(updatedInterview.getRound2Feedback());
        interview.setRound2Rating(updatedInterview.getRound2Rating());
        interview.setRound3Feedback(updatedInterview.getRound3Feedback());
        interview.setRound3Rating(updatedInterview.getRound3Rating());
        interview.setInterviewType(updatedInterview.getInterviewType());
        interview.setInterviewDuration(updatedInterview.getInterviewDuration());
        interview.setInterviewResult(updatedInterview.getInterviewResult());
        interview.setNotes(updatedInterview.getNotes());
        return interviewRepository.save(interview);
    }

    public void deleteInterview(Long interviewId) {
        interviewRepository.deleteById(interviewId);
    }
}
