package com.example.VacationCalculator.models;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public class VacationCalculationRequest {

    @NotNull
    @Min(value = 0)
    private BigDecimal averageSalary;

    @NotNull
    @Min(value = 1)
    private Integer vacationDays;


    public VacationCalculationRequest() {}

    public VacationCalculationRequest(BigDecimal averageSalary, Integer vacationDays) {
        this.averageSalary = averageSalary;
        this.vacationDays = vacationDays;
    }

    public BigDecimal getAverageSalary() {
        return averageSalary;
    }

    public void setAverageSalary(BigDecimal averageSalary) {
        this.averageSalary = averageSalary;
    }

    public Integer getVacationDays() {
        return vacationDays;
    }

    public void setVacationDays(Integer vacationDays) {
        this.vacationDays = vacationDays;
    }
}
