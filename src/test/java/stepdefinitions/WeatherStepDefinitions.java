package stepdefinitions;

import io.cucumber.java.en.Given;

import com.example.spring_mysql_api.service.WeatherService;
import com.example.spring_mysql_api.model.WeatherInfo;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

public class WeatherStepDefinitions {

    private WeatherService weatherService;
    private List<WeatherInfo> weatherInfoList;
    private Long cityId;
    private String jsonResponse;

    // Assuming you have a constructor to inject dependencies (like WeatherService)
    public WeatherStepDefinitions(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @Given("the system has cities data for a country in the database")
    public void the_system_has_cities_data_for_a_country_in_the_database() {
        // Implement logic to set up cities data in the database
        weatherService.addDataForCountry();
    }

    @When("a user requests the list of cities for a specific country")
    public void a_user_requests_the_list_of_cities_for_a_specific_country() {
        // Implement logic to make a request for the list of cities for a specific country
        weatherInfoList = weatherService.getAllWeatherInformation();
    }

    @Then("the system should return a JSON response with the list of cities in that country")
    public void the_system_should_return_a_json_response_with_the_list_of_cities_in_that_country() {
        // Implement logic to validate the JSON response with the list of cities
        // You can use assertions or other validation methods here
        // For example: assertEquals(expectedJsonResponse, actualJsonResponse);
    }

    @Given("the system has weather data for cities in the database")
    public void the_system_has_weather_data_for_cities_in_the_database() {
        // Implement logic to set up weather data in the database
        weatherService.addDataForCountry();
    }

    @When("a user requests weather information for a specific city by ID")
    public void a_user_requests_weather_information_for_a_specific_city_by_id() {
        // Implement logic to make a request for weather information for a specific city by ID
        WeatherInfo weatherInfo = weatherService.getWeatherByCityId(cityId).orElse(null);
        if (weatherInfo != null) {
            // Convert WeatherInfo object to JSON or any other response format
            jsonResponse = convertWeatherInfoToJsonResponse(weatherInfo);
        }
    }

    @Then("the system should return a JSON response with the current weather details for that city")
    public void the_system_should_return_a_json_response_with_the_current_weather_details_for_that_city() {
        // Implement logic to validate the JSON response with the current weather details
        // You can use assertions or other validation methods here
        // For example: assertEquals(expectedJsonResponse, actualJsonResponse);
    }

    // Additional helper methods can be added as needed
    private String convertWeatherInfoToJsonResponse(WeatherInfo weatherInfo) {
        // Implement logic to convert WeatherInfo object to JSON response
        // Return the JSON response as a string
        return "{ \"city\": \"" + weatherInfo.getCity() + "\", \"temperature\": \"" + weatherInfo.getTemperature() + "\" }";
    }
}
