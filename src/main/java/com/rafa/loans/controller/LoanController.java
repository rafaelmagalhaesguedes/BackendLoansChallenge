package com.rafa.loans.controller;

import com.rafa.loans.controller.dto.CustomerLoanRequest;
import com.rafa.loans.controller.dto.CustomerLoanResponse;
import com.rafa.loans.service.LoanService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer-loans")
public class LoanController {
    private final LoanService service;

    @Autowired
    public LoanController(LoanService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CustomerLoanResponse> customerLoans(@RequestBody @Valid CustomerLoanRequest loanRequest) {
        return ResponseEntity.ok(service.checkLoanAvailability(loanRequest));
    }
}
