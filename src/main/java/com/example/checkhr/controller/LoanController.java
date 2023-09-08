package com.example.checkhr.controller;

import com.example.checkhr.model.Loan;
import com.example.checkhr.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loans")
@CrossOrigin("*")

public class LoanController {
    @Autowired
    private LoanService loanService;

    @GetMapping
    public List<Loan> getAllLoans() {
        return loanService.getAllLoans();
    }

    @GetMapping("/unchecked")
    public List<Loan> getUncheckedLoans() {
        return loanService.getUncheckedLoans();
    }

    @PostMapping("/approve/{id}")
    public Loan approveLoanById(@PathVariable Long id) {
        return loanService.approveLoanById(id);
    }

    @PostMapping("/decline/{id}")
    public Loan declineLoanById(@PathVariable Long id) {
        return loanService.declineLoanById(id);
    }

    @PostMapping("/request")
    public Loan requestLoan(@RequestBody Loan loan) {
        return loanService.requestLoan(loan);
    }
}
