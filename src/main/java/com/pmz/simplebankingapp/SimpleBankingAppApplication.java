package com.pmz.simplebankingapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.pmz.simplebankingapp.repository")
public class SimpleBankingAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleBankingAppApplication.class, args);
    }
}
