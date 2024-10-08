package ru.iguana.vacationcalc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.MonthDay;
import java.util.HashSet;
import java.util.Set;

@Service
public class VacationcalcService {
    @Autowired
    private final Set<MonthDay> holidays = new HashSet<>();

    public double calculateVacationPay(double salaryForYear, int vacationDays, String dayOfStartVacation){
        /*
        12 - кол-во месяцев
        29.3 - Среднее количество календарных дней в полностью отработанных месяцах.
        именно оно используется для расчета средне-дневного заработка
        */
        double dailySalary = salaryForYear / (12 * 29.3);

        LocalDate date = LocalDate.parse(dayOfStartVacation);

        int paidVacationDays = 0; //дни отпуска без учета праздничных дней
        for (int i = 0; i < vacationDays; i++){
            if(!holidays.contains(MonthDay.of(date.getMonth(), date.getDayOfMonth()))) {
                paidVacationDays++;
            }
            date = date.plusDays(1);
        }
        return dailySalary * paidVacationDays - (dailySalary * paidVacationDays * 0.13); //13% НДФЛ
    }

    public double calculateVacationPay(double salaryForYear, int vacationDays){
        double dailySalary = salaryForYear / (12 * 29.3);
        return (dailySalary * vacationDays) - (dailySalary * vacationDays * 0.13); // 13% НДФЛ
    }
}
