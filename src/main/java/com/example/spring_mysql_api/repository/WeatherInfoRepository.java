package com.example.spring_mysql_api.repository;

import com.example.spring_mysql_api.model.WeatherInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WeatherInfoRepository extends JpaRepository<WeatherInfo, Long> {

    List<WeatherInfo> findByCountry(String country);

    WeatherInfo findByCityAndCountry(String city, String country);
}
