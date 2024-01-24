package com.example.spring_mysql_api.repository;

import com.example.spring_mysql_api.model.WeatherInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface WeatherInfoRepository extends JpaRepository<WeatherInfo, Long> {

    List<WeatherInfo> findByCountry(String country);

    Optional<WeatherInfo> findById(Long id);

    @Query("SELECT DISTINCT w FROM WeatherInfo w WHERE w.country = :country")
    Set<WeatherInfo> findDistinctByCountry(@Param("country") String country);

    WeatherInfo findByCityAndCountry(String city, String country);

}
