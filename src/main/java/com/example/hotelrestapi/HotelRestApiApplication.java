package com.example.hotelrestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {
    "models"
})
@EnableJpaRepositories(basePackages = {
        "repositories"
})
@SpringBootApplication(scanBasePackages = {
        "controllers",
        "data"
})
public class HotelRestApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(HotelRestApiApplication.class, args);
    }

}
