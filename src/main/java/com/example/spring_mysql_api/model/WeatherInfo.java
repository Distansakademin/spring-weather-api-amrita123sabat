package com.example.spring_mysql_api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "weather_info")
public class WeatherInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String city;
    private String country;
    private String temperature;
    private String weatherCondition;

    // Constructors, getters, setters (Lombok can be used for brevity)

    public WeatherInfo() {
    }

    public WeatherInfo(String city, String country, String temperature, String weatherCondition) {
        this.city = city;
        this.country = country;
        this.temperature = temperature;
        this.weatherCondition = weatherCondition;
    }

    // Getters and setters (Omitted for brevity)

    public Long getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getTemperature() {
        return temperature;
    }

    public String getWeatherCondition() {
        return weatherCondition;
    }
}
