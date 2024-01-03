package com.example.spring_mysql_api.service;

import org.springframework.stereotype.Service;


import com.example.spring_mysql_api.model.WeatherInfo;
import com.example.spring_mysql_api.repository.WeatherInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;  // Import statement for EntityNotFoundException
import java.util.List;

@Service
public class WeatherService {

    private final WeatherInfoRepository weatherInfoRepository;

    @Autowired
    public WeatherService(WeatherInfoRepository weatherInfoRepository) {
        this.weatherInfoRepository = weatherInfoRepository;
    }

    public List<WeatherInfo> getCitiesByCountry(String country) {
        return weatherInfoRepository.findByCountry(country);
    }

    public WeatherInfo getWeatherByCityId(Long cityId) {
        return weatherInfoRepository.findById(cityId)
                .orElseThrow(() -> new EntityNotFoundException("WeatherInfo with id " + cityId + " not found"));
    }

    @Transactional
    public void addDataForSweden() {
        WeatherInfo swedenCity1 = new WeatherInfo("Stockholm", "Sweden", "15.0", "Sunny");
        WeatherInfo swedenCity2 = new WeatherInfo("Gothenburg", "Sweden", "14.5", "Cloudy");

        weatherInfoRepository.saveAll(List.of(swedenCity1, swedenCity2));
    }
}
