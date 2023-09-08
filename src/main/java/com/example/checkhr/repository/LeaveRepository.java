package com.example.checkhr.repository;

import com.example.checkhr.model.Leaves;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LeaveRepository extends JpaRepository<Leaves,Long> {
    public List<Leaves> findByStatusIsNull();
}
