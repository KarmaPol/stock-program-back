package com.pgms.stockprogramback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class StockProgramBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(StockProgramBackApplication.class, args);
    }

}
