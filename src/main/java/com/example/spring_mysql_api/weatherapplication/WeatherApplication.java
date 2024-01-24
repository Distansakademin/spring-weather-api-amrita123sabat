package com.example.spring_mysql_api.weatherapplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import com.example.spring_mysql_api.service.WeatherService;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.spring_mysql_api")
public class WeatherApplication implements CommandLineRunner {

    private final WeatherService weatherService;

    @Autowired
    public WeatherApplication(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    public static void main(String[] args) {
        SpringApplication.run(WeatherApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        weatherService.addDataForCountry();
    }
}
