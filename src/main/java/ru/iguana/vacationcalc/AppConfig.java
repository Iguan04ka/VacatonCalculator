package ru.iguana.vacationcalc;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Configuration
public class AppConfig {
    @Bean
    public Set<LocalDate> holidays(){
        Set<LocalDate> holidays = new HashSet<>();

        for (int i = 1; i < 9; i++){
            //новогодние праздники 1-8 января
            holidays.add(LocalDate.of(LocalDate.now().getYear(), 1, i));
        }
        holidays.add(LocalDate.of(LocalDate.now().getYear(), 2, 23)); //23 февраля
        holidays.add(LocalDate.of(LocalDate.now().getYear(), 3, 8)); //8 марта
        holidays.add(LocalDate.of(LocalDate.now().getYear(), 5, 1)); //1 мая
        holidays.add(LocalDate.of(LocalDate.now().getYear(), 5, 9)); //9 мая
        holidays.add(LocalDate.of(LocalDate.now().getYear(), 6, 12)); //12 июня - день России
        holidays.add(LocalDate.of(LocalDate.now().getYear(), 11, 4)); //4 ноября - день народного единства
        return holidays;
    }
}
