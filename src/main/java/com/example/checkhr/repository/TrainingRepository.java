package com.example.checkhr.repository;

import com.example.checkhr.model.Training;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface    TrainingRepository  extends JpaRepository<Training,Long> {
    public List<Training> findByStatusIsNull();

}
