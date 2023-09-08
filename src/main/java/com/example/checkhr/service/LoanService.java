package com.example.checkhr.service;

import com.example.checkhr.model.Loan;
import com.example.checkhr.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanService {
    @Autowired
    private LoanRepository loanRepository;

    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }

    public List<Loan> getUncheckedLoans() {
        return loanRepository.findByStatusIsNull();
    }

    public Loan approveLoanById(Long id) {
        Loan loan = loanRepository.findById(id).orElse(null);
        if (loan != null && loan.getStatus() == null) {
            loan.setStatus(true);
            return loanRepository.save(loan);
        }
        return null; // Loan not found or already approved/declined
    }

    public Loan declineLoanById(Long id) {
        Loan loan = loanRepository.findById(id).orElse(null);
        if (loan != null && loan.getStatus() == null) {
            loan.setStatus(false);
            return loanRepository.save(loan);
        }
        return null; // Loan not found or already approved/declined
    }

    public Loan requestLoan(Loan loan) {
        // Set the status to null when requesting a loan
        loan.setStatus(null);
        return loanRepository.save(loan);
    }
}
