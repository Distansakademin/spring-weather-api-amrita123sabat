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
        // Mocking behavior of the WeatherService
        Mockito.doNothing().when(weatherService).addDataForCountry();

        try {
            // Call the run method
            weatherApplication.run();

            // Verify that addDataForCountry method was called
            Mockito.verify(weatherService, Mockito.times(1)).addDataForCountry();

            // Print statement for debugging/logging
            System.out.println("Test executed successfully!");
        } catch (Exception e) {
            // Handle the exception, print or log an error message if needed
            System.err.println("Exception caught in test: " + e.getMessage());
        }
    }
}
