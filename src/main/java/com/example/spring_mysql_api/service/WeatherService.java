package com.example.spring_mysql_api.service;

import com.example.spring_mysql_api.model.WeatherInfo;
import com.example.spring_mysql_api.repository.WeatherInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class WeatherService {

    @Autowired
    private WeatherInfoRepository weatherInfoRepository;

    public List<WeatherInfo> getCitiesByCountry(String country) {
        return weatherInfoRepository.findByCountry(country);
    }

    public WeatherInfo getWeatherByCityId(Long cityId) {
        return weatherInfoRepository.findById(cityId).orElse(null);
    }

    @Transactional
    public void addDataForSweden() {
        WeatherInfo swedenCity1 = new WeatherInfo("Stockholm", "Sweden", "15.0", "Sunny");
        WeatherInfo swedenCity2 = new WeatherInfo("Gothenburg", "Sweden", "14.5", "Cloudy");

        weatherInfoRepository.saveAll(List.of(swedenCity1, swedenCity2));
    }
}

