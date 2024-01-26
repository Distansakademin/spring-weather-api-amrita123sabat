package com.example.spring_mysql_api.weatherapplication;

// Other imports and class definition
import com.example.spring_mysql_api.service.WeatherService;
import com.example.spring_mysql_api.model.WeatherInfo;
import com.example.spring_mysql_api.repository.WeatherInfoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class WeatherServiceTest {

    @Mock
    private WeatherInfoRepository weatherInfoRepository;

    @InjectMocks
    private WeatherService weatherService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllCitiesAndCountries() {
        // Arrange
        List<WeatherInfo> mockWeatherInfoList = Arrays.asList(
                new WeatherInfo("Stockholm", "Sweden", "15.0", "Sunny"),
                new WeatherInfo("Gothenburg", "Sweden", "14.5", "Cloudy")
                // Add more data as needed
        );

        when(weatherInfoRepository.findAll()).thenReturn(mockWeatherInfoList);

        // Act
        List<String> result = weatherService.getAllCitiesAndCountries();

        // Assert
        List<String> expected = Arrays.asList("Gothenburg - Sweden", "Stockholm - Sweden");


        // Print sorted versions for debugging
        List<String> sortedExpected = new ArrayList<>(expected);
        sortedExpected.sort(Comparator.naturalOrder());

        List<String> sortedResult = new ArrayList<>(result);
        sortedResult.sort(Comparator.naturalOrder());

        // Print sorted versions
        System.out.println("Sorted Expected: " + sortedExpected);
        System.out.println("Sorted Actual  : " + sortedResult);

        // Assert
        assertTrue(sortedExpected.equals(sortedResult));
    }

    @Test
    void testGetWeatherByCityId() {
        // Arrange
        Long cityId = 1L;
        WeatherInfo mockWeatherInfo = new WeatherInfo("Stockholm", "Sweden", "15.0", "Sunny");

        when(weatherInfoRepository.findById(cityId)).thenReturn(Optional.of(mockWeatherInfo));

        // Act
        Optional<WeatherInfo> result = weatherService.getWeatherByCityId(cityId);

        // Assert
        assertTrue(result.isPresent());

        // Print actual and expected
        System.out.println("Expected: " + mockWeatherInfo);
        System.out.println("Actual  : " + result.orElse(null));

        assertEquals(mockWeatherInfo, result.orElse(null));
    }

    @Test
    void testGetAllWeatherInformation() {
        // Arrange
        List<WeatherInfo> mockWeatherInfoList = Arrays.asList(
                new WeatherInfo("Stockholm", "Sweden", "15.0", "Sunny"),
                new WeatherInfo("Gothenburg", "Sweden", "14.5", "Cloudy"),
                new WeatherInfo("Mumbai", "India", "30.0", "Hot"),
                new WeatherInfo("Delhi", "India", "28.5", "Clear"),
                new WeatherInfo("New York", "USA", "25.0", "Partly Cloudy"),
                new WeatherInfo("Los Angeles", "USA", "28.5", "Sunny"),
                new WeatherInfo("Tokyo", "Japan", "20.0", "Rainy"),
                new WeatherInfo("Osaka", "Japan", "22.5", "Cloudy")
        );

        when(weatherInfoRepository.findAll()).thenReturn(mockWeatherInfoList);

        // Act
        List<WeatherInfo> result = weatherService.getAllWeatherInformation();

        // Assert
        System.out.println("Expected: " + mockWeatherInfoList);
        System.out.println("Actual  : " + result);
        assertEquals(mockWeatherInfoList, result);
    }


    @Test
    void testAddDataForCountry() {
        // Arrange
        // Mock the saveAll method and specify its behavior
        when(weatherInfoRepository.saveAll(anyList())).thenReturn(Collections.emptyList());

        // Act
        weatherService.addDataForCountry();

        // Assert (Verify that the saveAll method was invoked with the correct data)
        verify(weatherInfoRepository, times(1)).saveAll(anyList());
    }
}
