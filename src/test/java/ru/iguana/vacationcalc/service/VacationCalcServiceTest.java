package ru.iguana.vacationcalc.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class VacationCalcServiceTest {
    @Autowired
    private VacationcalcService vcs;

    @Test
    void calculateVacationPayTest(){
        double pay = vcs.calculateVacationPay(600_000, 14);
        Assertions.assertEquals(20785.0, Math.round(pay));
    }
    @Test
    void calculateVacationPayTest_withStartDate(){
        double pay = vcs.calculateVacationPay(600_000, 14, "2024-05-01");
        Assertions.assertEquals(17816.0, Math.round(pay));
    }
}

