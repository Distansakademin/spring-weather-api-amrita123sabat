package com.example.spring_mysql_api.weatherapplication;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.spring_mysql_api.weatherapplication.WeatherApplication; // Make sure to import the WeatherApplication class
import com.example.spring_mysql_api.service.WeatherService;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class WeatherApplicationTest {

    @Mock
    private WeatherService weatherService;

    @InjectMocks
    private WeatherApplication weatherApplication;

    @Test
    public void testRunMethod() {

        Mockito.doNothing().when(weatherService).addDataForCountry();

        try {

            weatherApplication.run();

            Mockito.verify(weatherService, Mockito.times(1)).addDataForCountry();


            System.out.println("Test executed successfully!");
        } catch (Exception e) {

            System.err.println("Exception caught in test: " + e.getMessage());
        }
    }
}
