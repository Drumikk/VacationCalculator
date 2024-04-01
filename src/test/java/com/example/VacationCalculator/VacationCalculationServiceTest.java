package com.example.VacationCalculator;

import com.example.VacationCalculator.models.VacationCalculationResponse;
import com.example.VacationCalculator.services.VacationCalculationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class VacationCalculationServiceTest {

	private VacationCalculationService service;

	@BeforeEach
	public void setUp() {
		service = new VacationCalculationService();
	}

	@Test
	public void whenValidInput_thenCalculateVacationPay() {

		BigDecimal averageSalary = new BigDecimal("50000");
		int vacationDays = 15;


		VacationCalculationResponse response = service.calculateVacationPay(averageSalary, vacationDays);


		BigDecimal expectedVacationPay = averageSalary.divide(BigDecimal.valueOf(29.3), RoundingMode.HALF_UP)
				.multiply(BigDecimal.valueOf(vacationDays))
				.setScale(2, RoundingMode.HALF_UP);

		assertEquals(expectedVacationPay, response.getVacationPay(), "The calculated vacation pay should match the expected result.");
	}

	@Test
	public void whenSalaryIsZero_thenThrowException() {
		BigDecimal averageSalary = BigDecimal.ZERO;
		int vacationDays = 10;


		assertThrows(
				IllegalArgumentException.class,
				() -> service.calculateVacationPay(averageSalary, vacationDays),
				"Expected calculateVacationPay to throw, but it didn't"
		);
	}


}
