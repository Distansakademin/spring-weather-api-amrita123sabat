package com.example.spring_mysql_api.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

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

    // Constructors (default and parameterized)
    public WeatherInfo() {
    }

    public WeatherInfo(String city, String country, String temperature, String weatherCondition) {

        this.city = city;
        this.country = country;
        this.temperature = temperature;
        this.weatherCondition = weatherCondition;
    }

    // Getters and setters (Lombok can be used for brevity, but manually provided here)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getWeatherCondition() {
        return weatherCondition;
    }

    public void setWeatherCondition(String weatherCondition) {
        this.weatherCondition = weatherCondition;
    }


    // toString method (you may customize it as needed)
    @Override
    public String toString() {
        return "WeatherInfo{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", temperature='" + temperature + '\'' +
                ", weatherCondition='" + weatherCondition + '\'' +
                '}';
    }




}
