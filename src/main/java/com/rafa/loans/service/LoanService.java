package com.rafa.loans.service;

import com.rafa.loans.controller.dto.CustomerLoanRequest;
import com.rafa.loans.controller.dto.CustomerLoanResponse;
import com.rafa.loans.controller.dto.LoanResponse;
import com.rafa.loans.domain.Loan;
import com.rafa.loans.domain.LoanType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoanService {

    public CustomerLoanResponse checkLoanAvailability(CustomerLoanRequest loanRequest) {
        var customer = loanRequest.toEntity();
        var loan = new Loan(customer);

        List<LoanResponse> loans = new ArrayList<>();

        if (loan.isPersonLoanAvailable()) {
            var personalLoan = new LoanResponse(LoanType.PERSONAL, loan.getPersonalLoanInterestRate());
            loans.add(personalLoan);
        }

        if (loan.isConsigmentLoanAvailable()) {
            var consigmentLoan = new LoanResponse(LoanType.CONSIGNMENT, loan.getConsigmentLoanInterestRate());
            loans.add(consigmentLoan);
        }

        if (loan.isGuaranteedLoanAvailable()) {
            var guaranteedLoan = new LoanResponse(LoanType.GUARANTEED, loan.getGuaranteedLoanInterestRate());
            loans.add(guaranteedLoan);
        }

        return new CustomerLoanResponse(loanRequest.name(), loans);
    }
}
