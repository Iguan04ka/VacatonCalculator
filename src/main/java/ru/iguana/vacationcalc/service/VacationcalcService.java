package ru.iguana.vacationcalc.service;

import org.springframework.stereotype.Service;

@Service
public class VacationcalcService {
    public double calculateVacationPay(double salary, int vacationDays){
        double dailySalary = salary / 30;
        double payout = dailySalary * vacationDays;
        return payout;
    }
}
