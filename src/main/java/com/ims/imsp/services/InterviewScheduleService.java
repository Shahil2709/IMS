package com.ims.imsp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ims.imsp.dao.InterviewScheduleRepository;
import com.ims.imsp.entities.InterviewSchedule;

@Service
public class InterviewScheduleService {
    @Autowired
    private InterviewScheduleRepository interviewScheduleRepository;

    public InterviewSchedule createInterviewSchedule(InterviewSchedule interviewSchedule) {
        return interviewScheduleRepository.save(interviewSchedule);
    }

    public List<InterviewSchedule> getAllInterviewSchedules() {
        return interviewScheduleRepository.findAll();
    }

    public InterviewSchedule getInterviewScheduleById(Long scheduleId) {
        return interviewScheduleRepository.findById(scheduleId).orElse(null);
    }

    public InterviewSchedule updateInterviewSchedule(Long scheduleId, InterviewSchedule updatedSchedule) {
        InterviewSchedule schedule = interviewScheduleRepository.findById(scheduleId).orElse(null);
        if (schedule == null) {
            return null;
        }
        schedule.setInterview(updatedSchedule.getInterview());
        schedule.setRound(updatedSchedule.getRound());
        schedule.setInterviewer(updatedSchedule.getInterviewer());
        schedule.setScheduledDate(updatedSchedule.getScheduledDate());
        schedule.setScheduledTime(updatedSchedule.getScheduledTime());
        schedule.setLocation(updatedSchedule.getLocation());
        schedule.setStatus(updatedSchedule.getStatus());
        return interviewScheduleRepository.save(schedule);
    }

    public void deleteInterviewSchedule(Long scheduleId) {
        interviewScheduleRepository.deleteById(scheduleId);
    }
}
