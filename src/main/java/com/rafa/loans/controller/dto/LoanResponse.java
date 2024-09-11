package com.rafa.loans.controller.dto;

import com.rafa.loans.domain.LoanType;

public record LoanResponse(
        LoanType type,
        Double interestRate
) {
}
