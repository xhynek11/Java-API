package com.example.demo.employ;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class EmployConfig {

    @Bean
    CommandLineRunner commandLineRunner(EmployRepository repository){
        return args -> {
            Employ john = new Employ(
                    "John",
                    LocalDate.of(1999, JULY,21),
                    "john.tt@gmail.com",
                    50000
            );

            Employ tony = new Employ(
                    "Tony",
                    LocalDate.of(1995, JULY,6),
                    "tony.ds@gmail.com",
                    45000
            );

            repository.saveAll(List.of(john,tony));
        };
    }
}
