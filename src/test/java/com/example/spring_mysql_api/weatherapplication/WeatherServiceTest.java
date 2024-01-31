package com.example.spring_mysql_api.weatherapplication;

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

        List<WeatherInfo> mockWeatherInfoList = Arrays.asList(
                new WeatherInfo("Stockholm", "Sweden", "15.0", "Sunny"),
                new WeatherInfo("Gothenburg", "Sweden", "14.5", "Cloudy")

        );

        when(weatherInfoRepository.findAll()).thenReturn(mockWeatherInfoList);


        List<String> result = weatherService.getAllCitiesAndCountries();


        List<String> expected = Arrays.asList("Gothenburg - Sweden", "Stockholm - Sweden");



        List<String> sortedExpected = new ArrayList<>(expected);
        sortedExpected.sort(Comparator.naturalOrder());

        List<String> sortedResult = new ArrayList<>(result);
        sortedResult.sort(Comparator.naturalOrder());


        System.out.println("Sorted Expected: " + sortedExpected);
        System.out.println("Sorted Actual  : " + sortedResult);


        assertTrue(sortedExpected.equals(sortedResult));
    }

    @Test
    void testGetWeatherByCityId() {

        Long cityId = 1L;
        WeatherInfo mockWeatherInfo = new WeatherInfo("Stockholm", "Sweden", "15.0", "Sunny");

        when(weatherInfoRepository.findById(cityId)).thenReturn(Optional.of(mockWeatherInfo));


        Optional<WeatherInfo> result = weatherService.getWeatherByCityId(cityId);


        assertTrue(result.isPresent());


        System.out.println("Expected: " + mockWeatherInfo);
        System.out.println("Actual  : " + result.orElse(null));

        assertEquals(mockWeatherInfo, result.orElse(null));
    }

    @Test
    void testGetAllWeatherInformation() {

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


        List<WeatherInfo> result = weatherService.getAllWeatherInformation();


        System.out.println("Expected: " + mockWeatherInfoList);
        System.out.println("Actual  : " + result);
        assertEquals(mockWeatherInfoList, result);
    }


    @Test
    void testAddDataForCountry() {

        when(weatherInfoRepository.saveAll(anyList())).thenReturn(Collections.emptyList());


        weatherService.addDataForCountry();


        verify(weatherInfoRepository, times(1)).saveAll(anyList());
    }
}
