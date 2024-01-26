Feature: Weather Information API

  Scenario: Retrieve Weather Information
    Given the API endpoint is "http://localhost:8080/api/weatherinformation"
    When I make a GET request to the API
    Then the response should be successful
    And the response should include the following weather information:
      | id | city        | country | temperature | weatherCondition |
      | 1  | Stockholm   | Sweden  | 15.00       | Sunny            |
      | 2  | Gothenburg  | Sweden  | 14.50       | Cloudy           |
      | 3  | Mumbai      | India   | 30.00       | Hot              |
      | 4  | Delhi       | India   | 28.50       | Clear            |
      | 5  | New York     | USA     | 25.00       | Partly Cloudy    |
      | 6  | Los Angeles  | USA     | 28.50       | Sunny            |
      | 7  | Tokyo        | Japan   | 20.00       | Rainy            |
      | 8  | Osaka        | Japan   | 22.50       | Cloudy           |

