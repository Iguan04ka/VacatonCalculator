package ru.iguana.vacationcalc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.iguana.vacationcalc.service.VacationcalcService;

@RestController
public class VacationcalcController {
    @Autowired
    private VacationcalcService service;

    @GetMapping("/calculate")
    public double calculate(
            @RequestParam double avgSalary,
            @RequestParam int vacationDays,
            @RequestParam(required = false) String startDate){
        return this.service.calculateVacationPay(avgSalary, vacationDays);
    }
}
