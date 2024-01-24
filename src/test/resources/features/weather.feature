Feature: Weather Information

  Scenario: Retrieving cities by country
    Given the country code is "Sweden"
    When I request the list of cities
    Then the response should include the following cities:
      | City         |
      | Stockholm    |
      | Gothenburg   |

  Scenario: Retrieving weather by city ID
    Given the city ID is 1
    When I request the weather information
    Then the response should include the weather conditions


C:\Users\amrit\OneDrive\Documents\GitHub\spring-weather-api-amrita123sabat\src\test\resources