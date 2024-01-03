package com.example.spring_mysql_api.wetherapplication.controller;

import com.example.spring_mysql_api.model.WeatherInfo;
import com.example.spring_mysql_api.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/{country}/cities")
    public ResponseEntity<List<WeatherInfo>> getCitiesByCountry(@PathVariable String country) {
        List<WeatherInfo> cities = weatherService.getCitiesByCountry(country);
        return ResponseEntity.ok(cities);
    }

    @GetMapping("/weather/{cityId}")
    public ResponseEntity<WeatherInfo> getWeatherByCityId(@PathVariable Long cityId) {
        WeatherInfo weatherInfo = weatherService.getWeatherByCityId(cityId);
        if (weatherInfo != null) {
            return ResponseEntity.ok(weatherInfo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
