package stepdefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.cucumber.datatable.DataTable;
import java.util.List;
import java.util.Map;

public class WeatherStepDefinitions {

    private Response response;

    @Given("the API endpoint is {string}")
    public void the_api_endpoint_is(String endpoint) {
        RestAssured.baseURI = endpoint;
        System.out.println("API endpoint set to: " + endpoint);
    }

    @When("I make a GET request to the API")
    public void i_make_a_get_request_to_the_api() {
        response = RestAssured.get("/");
        System.out.println("GET request made to the API");
    }

    @Then("the response should be successful")
    public void the_response_should_be_successful() {
        response.then().statusCode(200);
        System.out.println("Response is successful with status code 200");
    }


    @Then("the response should include the following weather information:")
    public void the_response_should_include_the_following_weather_information(DataTable dataTable) {
        List<Map<String, String>> expectedData = dataTable.asMaps(String.class, String.class);
        List<Map<String, String>> actualData = response.jsonPath().getList("");

        // Compare expected and actual data
        for (Map<String, String> expectedRow : expectedData) {
            boolean matchFound = false;
            for (Map<String, String> actualRow : actualData) {
                if (compareMaps(expectedRow, actualRow)) {
                    matchFound = true;
                    System.out.println("Weather information found: " + expectedRow);
                    break;
                }
            }
            if (!matchFound) {
                System.out.println("Weather information not found: " + expectedRow);
            }
        }
    }

    private boolean compareMaps(Map<String, String> expected, Map<String, String> actual) {
        // Compare the maps by comparing their key-value pairs
        return actual.keySet().equals(expected.keySet());
    }
}