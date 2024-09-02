package ru.iguana.vacationcalc;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.MonthDay;
import java.util.HashSet;
import java.util.Set;

@Configuration
public class AppConfig {
    @Bean
    public Set<MonthDay> holidays(){
        Set<MonthDay> holidays = new HashSet<>();

        for (int i = 1; i < 9; i++){
            //новогодние праздники 1-8 января
            holidays.add(MonthDay.of(1, i));
        }
        holidays.add(MonthDay.of(2, 23)); //23 февраля
        holidays.add(MonthDay.of(3, 8)); //8 марта
        holidays.add(MonthDay.of(5, 1)); //1 мая
        holidays.add(MonthDay.of(5, 9)); //9 мая
        holidays.add(MonthDay.of(6, 12));; //12 июня - день России
        holidays.add(MonthDay.of(11, 4)); //4 ноября - день народного единства
        return holidays;
    }
}
