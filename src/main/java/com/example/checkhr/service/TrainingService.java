package com.example.checkhr.service;

import com.example.checkhr.model.Training;
import com.example.checkhr.repository.TrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingService {
    @Autowired
    private TrainingRepository trainingRepository;

    public List<Training> getAllTrainings() {
        return trainingRepository.findAll();
    }

    public List<Training> getUncheckedTrainings() {
        return trainingRepository.findByStatusIsNull();
    }

    public Training approveTrainingById(Long id) {
        Training training = trainingRepository.findById(id).orElse(null);
        if (training != null && training.getStatus() == null) {
            training.setStatus(true);
            return trainingRepository.save(training);
        }
        return null; // Training not found or already approved/declined
    }

    public Training declineTrainingById(Long id) {
        Training training = trainingRepository.findById(id).orElse(null);
        if (training != null && training.getStatus() == null) {
            training.setStatus(false);
            return trainingRepository.save(training);
        }
        return null; // Training not found or already approved/declined
    }

    public Training requestTraining(Training training) {
        // Set the status to null when requesting a training
        training.setStatus(null);
        return trainingRepository.save(training);
    }
}
