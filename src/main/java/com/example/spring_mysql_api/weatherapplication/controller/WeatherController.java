package com.example.spring_mysql_api.weatherapplication.controller;
import com.example.spring_mysql_api.model.WeatherInfo;
import com.example.spring_mysql_api.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;
    public void setWeatherService(WeatherService weatherService) {
        this.weatherService = weatherService;
    }
    @GetMapping("/")
    public ResponseEntity<String> welcome() {
        return ResponseEntity.ok("Welcome to the Weather Application!");
    }


    @GetMapping("/weatherinformation")
    public ResponseEntity<List<WeatherInfo>> getAllWeatherInformation() {
        List<WeatherInfo> allWeatherInformation = weatherService.getAllWeatherInformation();
        return ResponseEntity.ok(allWeatherInformation);
    }
    @GetMapping("/cities-and-countries")
    public ResponseEntity<List<Map<String, Object>>> getCitiesAndCountries() {
        List<WeatherInfo> allWeatherInformation = weatherService.getAllWeatherInformation();

        Map<String, List<String>> citiesByCountry = allWeatherInformation.stream()
                .collect(Collectors.groupingBy(
                        WeatherInfo::getCountry,
                        Collectors.mapping(WeatherInfo::getCity, Collectors.toList())
                ));

        List<Map<String, Object>> result = new ArrayList<>();
        citiesByCountry.forEach((country, cities) -> {
            Map<String, Object> countryInfo = new HashMap<>();
            countryInfo.put("country", country);
            countryInfo.put("cities", cities);
            result.add(countryInfo);
        });

        return ResponseEntity.ok(result);
    }
    @GetMapping("/weather/{cityId}")
    public ResponseEntity<Optional<WeatherInfo>> getWeatherByCityId(@PathVariable Long cityId) {

        Optional<WeatherInfo> weatherInfo = weatherService.getWeatherByCityId(cityId);

        if (weatherInfo.isPresent()) {
            return ResponseEntity.ok(weatherInfo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/weather")
    public ResponseEntity<String> addWeatherInfo(@RequestBody WeatherInfo weatherInfo) {
        weatherService.saveWeatherInfo(weatherInfo);
        return ResponseEntity.ok("Weather information added successfully!");
    }

    @PutMapping("/weather/{cityId}")
    public ResponseEntity<String> updateWeatherInfo(@PathVariable Long cityId, @RequestBody WeatherInfo updatedWeatherInfo) {
        weatherService.updateWeatherInfo(cityId, updatedWeatherInfo);
        return ResponseEntity.ok("Weather information updated successfully!");
    }

}