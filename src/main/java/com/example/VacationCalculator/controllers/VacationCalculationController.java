package com.example.VacationCalculator.controllers;
import com.example.VacationCalculator.models.VacationCalculationRequest;
import com.example.VacationCalculator.models.VacationCalculationResponse;
import com.example.VacationCalculator.services.VacationCalculationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class VacationCalculationController {

    private final VacationCalculationService calculationService;

    public VacationCalculationController(VacationCalculationService calculationService) {
        this.calculationService = calculationService;
    }

    @GetMapping("/calculate")
    public ResponseEntity<VacationCalculationResponse> calculateVacationPay(
            @Valid @RequestBody VacationCalculationRequest request) {

        VacationCalculationResponse response = calculationService.calculateVacationPay(
                request.getAverageSalary(), request.getVacationDays());

        return ResponseEntity.ok(response);
    }
}
