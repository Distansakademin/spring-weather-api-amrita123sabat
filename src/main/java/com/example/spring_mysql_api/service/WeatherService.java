package com.example.spring_mysql_api.service;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.spring_mysql_api.model.WeatherInfo;
import com.example.spring_mysql_api.repository.WeatherInfoRepository;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;

@Service
public class WeatherService {

    public String getWelcomeMessage() {
        // Your implementation to get the welcome message
        return "Welcome to the Weather Application!";
    }

    private final WeatherInfoRepository weatherInfoRepository;

    public WeatherService(WeatherInfoRepository weatherInfoRepository) {
        this.weatherInfoRepository = weatherInfoRepository;
    }
    public List<String> getAllCitiesAndCountries() {
        List<WeatherInfo> allCities = weatherInfoRepository.findAll();

        Set<String> citiesAndCountries = new HashSet<>();

        for (WeatherInfo city : allCities) {
            citiesAndCountries.add(city.getCity() + " - " + city.getCountry());
        }

        return new ArrayList<>(citiesAndCountries);
    }
    public Optional<WeatherInfo> getWeatherByCityId(Long cityId) {
        System.out.println("Debasis4");
        return weatherInfoRepository.findById(cityId);
    }

    public List<WeatherInfo> getAllWeatherInformation() {
        System.out.println("Debasis");
        List<WeatherInfo> allCities = weatherInfoRepository.findAll();

        Set<String> processedCities = new HashSet<>();
        List<WeatherInfo> uniqueCities = new ArrayList<>();

        for (WeatherInfo city : allCities) {
            // Check if the city has already been processed
            if (!processedCities.contains(city.getCity())) {
                uniqueCities.add(city);
                processedCities.add(city.getCity());
            }
        }

        return uniqueCities;
    }


    @Transactional
    public void addDataForCountry() {
        WeatherInfo swedenCity1 = new WeatherInfo("Stockholm", "Sweden", "15.0", "Sunny");
        WeatherInfo swedenCity2 = new WeatherInfo("Gothenburg", "Sweden", "14.5", "Cloudy");

        // Data for India
        WeatherInfo indiaCity1 = new WeatherInfo("Mumbai", "India", "30.0", "Hot");
        WeatherInfo indiaCity2 = new WeatherInfo("Delhi", "India", "28.5", "Clear");

        // Data for USA
        WeatherInfo usaCity1 = new WeatherInfo("New York", "USA", "25.0", "Partly Cloudy");
        WeatherInfo usaCity2 = new WeatherInfo("Los Angeles", "USA", "28.5", "Sunny");

        // Data for Japan
        WeatherInfo japanCity1 = new WeatherInfo("Tokyo", "Japan", "20.0", "Rainy");
        WeatherInfo japanCity2 = new WeatherInfo("Osaka", "Japan", "22.5", "Cloudy");

        // Save all weather information
        weatherInfoRepository.saveAll(List.of(swedenCity1, swedenCity2, indiaCity1, indiaCity2, usaCity1, usaCity2, japanCity1, japanCity2));
    }
}