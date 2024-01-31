package com.example.spring_mysql_api.weatherapplication;

import com.example.spring_mysql_api.model.WeatherInfo;
import com.example.spring_mysql_api.service.WeatherService;
import com.example.spring_mysql_api.weatherapplication.controller.WeatherController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.*;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class WeatherControllerTest {

    @Mock
    private WeatherService weatherService;

    @InjectMocks
    private WeatherController weatherController;
    @Test
    public void testWelcome() {

        ResponseEntity<String> response = weatherController.welcome();


        assertEquals("Welcome to the Weather Application!", response.getBody());

        System.out.println("Welcome Endpoint Response: " + response);
    }
    @Test
    public void testGetAllWeatherInformation() {

        WeatherInfo city1 = new WeatherInfo("Stockholm", "Sweden", "15.0", "Sunny");
        WeatherInfo city2 = new WeatherInfo("Gothenburg", "Sweden", "14.5", "Cloudy");
        WeatherInfo city3 = new WeatherInfo("Mumbai", "India", "30.0", "Hot");
        WeatherInfo city4 = new WeatherInfo("Delhi", "India", "28.5", "Clear");
        WeatherInfo city5 = new WeatherInfo("New York", "USA", "25.0", "Partly Cloudy");
        WeatherInfo city6 = new WeatherInfo("Los Angeles", "USA", "28.5", "Sunny");
        WeatherInfo city7 = new WeatherInfo("Tokyo", "Japan", "20.0", "Rainy");
        WeatherInfo city8 = new WeatherInfo("Osaka", "Japan", "22.5", "Cloudy");

        List<WeatherInfo> mockWeatherInfoList = List.of(city1, city2, city3, city4, city5, city6, city7, city8);

        when(weatherService.getAllWeatherInformation()).thenReturn(mockWeatherInfoList);


        ResponseEntity<List<WeatherInfo>> response = weatherController.getAllWeatherInformation();


        assertEquals(mockWeatherInfoList, response.getBody());


        System.out.println("GetAllWeatherInformation Endpoint Response: " + response);

        if (response.getBody() != null) {
            System.out.println("Weather Information Details:");
            response.getBody().forEach(weatherInfo ->
                    System.out.println(weatherInfo.getCity() + ", " + weatherInfo.getCountry() +
                            ", " + weatherInfo.getTemperature() + ", " + weatherInfo.getWeatherCondition()));
        }
    }
    @Test
    public void testGetWeatherByCityId() {

        WeatherInfo city1 = new WeatherInfo("Stockholm", "Sweden", "15.0", "Sunny");
        WeatherInfo city2 = new WeatherInfo("Gothenburg", "Sweden", "14.5", "Cloudy");
        WeatherInfo city3 = new WeatherInfo("Mumbai", "India", "30.0", "Hot");
        WeatherInfo city4 = new WeatherInfo("Delhi", "India", "28.5", "Clear");
        WeatherInfo city5 = new WeatherInfo("New York", "USA", "25.0", "Partly Cloudy");
        WeatherInfo city6 = new WeatherInfo("Los Angeles", "USA", "28.5", "Sunny");
        WeatherInfo city7 = new WeatherInfo("Tokyo", "Japan", "20.0", "Rainy");
        WeatherInfo city8 = new WeatherInfo("Osaka", "Japan", "22.5", "Cloudy");

        Optional<WeatherInfo> mockWeatherInfo = Optional.of(city1);

        when(weatherService.getWeatherByCityId(1L)).thenReturn(mockWeatherInfo);


        ResponseEntity<Optional<WeatherInfo>> response = weatherController.getWeatherByCityId(1L);


        assertEquals(mockWeatherInfo, response.getBody());


        System.out.println("GetWeatherByCityId Endpoint Response: " + response);

        if (response.getBody().isPresent()) {
            WeatherInfo weatherInfo = response.getBody().get();
            System.out.println("Weather Information Details:");
            System.out.println(weatherInfo.getCity() + ", " + weatherInfo.getCountry() +
                    ", " + weatherInfo.getTemperature() + ", " + weatherInfo.getWeatherCondition());
        }
    }
    @Test
    public void testGetCitiesAndCountries() {

        List<WeatherInfo> weatherInfoList = Arrays.asList(
                new WeatherInfo("Stockholm", "Sweden", "15.0", "Sunny"),
                new WeatherInfo("Gothenburg", "Sweden", "14.5", "Cloudy"),
                new WeatherInfo("Mumbai", "India", "30.0", "Hot"),
                new WeatherInfo("Delhi", "India", "28.5", "Clear"),
                new WeatherInfo("New York", "USA", "25.0", "Partly Cloudy"),
                new WeatherInfo("Los Angeles", "USA", "28.5", "Sunny"),
                new WeatherInfo("Tokyo", "Japan", "20.0", "Rainy"),
                new WeatherInfo("Osaka", "Japan", "22.5", "Cloudy")
        );

        when(weatherService.getAllWeatherInformation()).thenReturn(weatherInfoList);


        ResponseEntity<List<Map<String, Object>>> response = weatherController.getCitiesAndCountries();


        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());

        List<Map<String, Object>> responseBody = response.getBody();
        assertNotNull(responseBody);
        assertEquals(4, responseBody.size()); // Assuming four countries in the provided data


        verify(weatherService, times(1)).getAllWeatherInformation();


        assertCountry(responseBody, "Sweden", "Stockholm", "Gothenburg");
        assertCountry(responseBody, "India", "Mumbai", "Delhi");
        assertCountry(responseBody, "USA", "New York", "Los Angeles");
        assertCountry(responseBody, "Japan", "Tokyo", "Osaka");


        System.out.println("Cities and Countries Endpoint Response: " + response);


        System.out.println("Print Cities and Countries Details:");
        responseBody.forEach(country -> {
            System.out.println("Country: " + country.get("country"));
            List<String> cities = (List<String>) country.get("cities");
            System.out.println("Cities: " + cities);
        });
    }

    private void assertCountry(List<Map<String, Object>> responseBody, String expectedCountry, String... expectedCities) {
        Optional<Map<String, Object>> country = responseBody.stream()
                .filter(c -> expectedCountry.equals(c.get("country")))
                .findFirst();

        assertTrue(country.isPresent());
        List<String> cities = (List<String>) country.get().get("cities");
        assertNotNull(cities);
        assertEquals(Arrays.asList(expectedCities), cities);
    }
}
