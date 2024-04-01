package com.example.VacationCalculator.models;

import java.math.BigDecimal;

public class VacationCalculationResponse {
    private BigDecimal vacationPay;
    public VacationCalculationResponse() {}

    public VacationCalculationResponse(BigDecimal vacationPay) {
        this.vacationPay = vacationPay;
    }

    public BigDecimal getVacationPay() {
        return vacationPay;
    }

    public void setVacationPay(BigDecimal vacationPay) {
        this.vacationPay = vacationPay;
    }
}
