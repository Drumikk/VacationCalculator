package com.example.VacationCalculator.services;

import com.example.VacationCalculator.models.VacationCalculationResponse;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class VacationCalculationService {

    public VacationCalculationResponse calculateVacationPay(BigDecimal averageSalary, int vacationDays) {
            if (averageSalary == null || averageSalary.compareTo(BigDecimal.ZERO) <= 0 || vacationDays <= 0) {
                throw new IllegalArgumentException("Invalid salary or vacation days");
            }

        BigDecimal dailyRate = averageSalary.divide(BigDecimal.valueOf(29.3), RoundingMode.HALF_UP);
        BigDecimal vacationPay = dailyRate.multiply(BigDecimal.valueOf(vacationDays));

        return new VacationCalculationResponse(vacationPay.setScale(2, RoundingMode.HALF_UP));
    }
}
