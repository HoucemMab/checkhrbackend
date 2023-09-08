package com.example.checkhr.repository;

import com.example.checkhr.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface    LoanRepository extends JpaRepository<Loan,Long> {
    public List<Loan> findByStatusIsNull();
}
