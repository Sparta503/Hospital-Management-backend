package com.DiorHomme.hospital.service;

import com.DiorHomme.hospital.model.Feedback;
import com.DiorHomme.hospital.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    public List<Feedback> getAllFeedback() {
        return feedbackRepository.findAll();
    }

    public Feedback submitFeedback(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    public Optional<Feedback> getFeedbackById(Long id) {
        return feedbackRepository.findById(id);
    }
}
