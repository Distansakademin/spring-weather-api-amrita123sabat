# Spring Weather API

## Introduction
This project is a Spring Boot based web application that manages information about
countries, cities and weather. An important aspect of the project is the use of 
Docker for easier management of both the application and the database environment.
By containerizing the application with Docker, one can run the application 
without compatibility problems.

# Project Goals

The goal of this project is to develop a comprehensive Spring Boot application with 
the following objectives:

## 1. Manage Countries and Cities

Enable users to perform CRUD (Create, Read, Update, Delete) operations on 
weather information about countries and cities. 

## 2. Weather Information Integration

Integrate weather information for cities into the application. This involves 
fetching and displaying weather data for various cities, providing users with 
real-time weather updates.


## 3. Continuous Integration

Utilize GitHub Actions to implement continuous integration (CI) practices. 
Automate the process of running tests to ensure code quality and reliability. 
This involves automatically triggering test suites whenever code changes are pushed 
to the repository.

## 4. Docker Containerization

Containerize the application using Docker. This enables consistent deployment 
across different environments and simplifies the setup process by encapsulating the 
application and its dependencies into lightweight containers.

## f. UML Diagram

UML (Unified Modeling Language) diagram to model the application
This diagram provide a visual representation of the application's structure and 
relationships between its components. I have chosen to make a class diagram in Draw.io . 

## 6. BDD (Behavior-Driven Development) and TDD (Test-Driven Development)

BDD techniques to define user stories and scenarios, ensuring that the
application meets user requirements and behaves as expected. 
By achieving these goals, the project aims to deliver a robust, user-friendly, 
and well-tested Spring Boot application that effectively manages countries, cities, 
and weather information.

## 7. Unit Testing( Using Junit and Mockito)

comprehensive unit tests using JUnit to validate individual components of the 
application. These tests verify the functionality of methods and classes in isolation,
ensuring that each unit behaves as expected. Unit testing helps identify and 
fix bugs early in the development process, improving code quality and maintainability.
By achieving these goals, the project aims to deliver a robust, user-friendly, and 
well-tested Spring Boot application that effectively manages countries, cities, and 
weather information.Implemented TDD practices to develop JUnit test cases before 
writing code, ensuring code correctness and test coverage. TDD ensures that new 
features are developed incrementally and in a testable manner.


### Prerequisites

    - Java 17
    - Maven
    - MySQL (Update your `application.properties` with the correct database configuration)
    _ Docker

### Running the Application

1. Clone the repository:
   git clone https://github.com/Distansakademin/spring-weather-api-amrita123sabat
   cd spring-weather-api-amrita123sabat


2. Build the application:
   ./mvnw clean install

Run the Application:
./mvnw spring-boot:run


Access the API:

1. Package model: WeatherInfo class
2. Package Controller:WeatherController class
3. Package Repository:WeatherInfoRepository
4. Package Service:WeatherService class
5. package weatherapplication:WeatherApplication class


- Weather Information:
  http://localhost:8080/api/weatherinformation
  - Cities and Countries:
  http://localhost:8080/api/cities-and-countries
  - Welcome:
  http://localhost:8080/api/
  - Weather by City ID
  http://localhost:8080/api/weather/1

## API Endpoints

### Welcome

- **Endpoint:** /
- **Method:** GET
- **Description:** Welcome message.

### Weather Information

- **Endpoint:** /weatherinformation
- **Method:** GET
- **Description:** Get all weather information.

### Cities and Countries

- **Endpoint:** /cities-and-countries
- **Method:** GET
- **Description:** Get a list of cities grouped by country.

### Weather by City ID

- **Endpoint:** /weather/{cityId}
- **Method:** GET
- **Description:** Get weather information by City ID.

# Data Population and Usage in Weather Application

The Weather Application comes preloaded with weather information for 8 cities. 
Additionally, users can dynamically add new city data using the POST method.

## Preloaded Data

The application is preloaded with weather information for the following cities:

1. **Stockholm, Sweden**
    - Temperature: 15.00°C
    - Weather Condition: Sunny

2. **Gothenburg, Sweden**
    - Temperature: 14.50°C
    - Weather Condition: Cloudy

3. **Mumbai, India**
    - Temperature: 30.00°C
    - Weather Condition: Hot

4. **Delhi, India**
    - Temperature: 28.50°C
    - Weather Condition: Clear

5. **New York, USA**
    - Temperature: 25.00°C
    - Weather Condition: Partly Cloudy

6. **Los Angeles, USA**
    - Temperature: 28.50°C
    - Weather Condition: Sunny

7. **Tokyo, Japan**
    - Temperature: 20.00°C
    - Weather Condition: Rainy

8. **Osaka, Japan**
    - Temperature: 22.50°C
    - Weather Condition: Cloudy

## Adding Data through POST Method

Users can add additional city data dynamically using the POST method. 
Here's an example of how to add a new city:

1. **POST Method**:

    - Endpoint: http://localhost:8080/api/weather
    - Content-Type: application/json
    - Request Body:
      json
    - {
          "city": "Berlin",
          "country": "Germany",
          "temperature": "18.00",
          "weatherCondition": "Sunny"
      }
      
2. 
   {
   "city": "Paris",
   "country": "France",
   "temperature": "20.50",
   "weatherCondition": "Partly Cloudy"
   }

## Conclusion

With the preloaded data and the ability to add new city data dynamically 
through the POST method, users can efficiently manage weather information within 
the Weather Application.

## Modifying Data through PUT Method

Users can modify existing city data dynamically using the PUT method.

## Data Storage

The application uses MySQL for data storage.
Update application.properties with your MySQL configuration.
In MySQL workbench my schema name is "mydatabase"
Created a table with name "weather_info" which shows all stored weather details

## Docker Configuration

To run the application using Docker, follow these steps:

1. Make sure you have Docker installed on your machine.
2. Navigate to the project directory
3. docker-compose build
4. docker-compose up -d
5.  docker-compose down

Access the API :

     Weather Information:
        http://localhost:8888/api/weatherinformation

     Cities and Countries:
        http://localhost:8888/api/cities-and-countries

     Welcome:
        http://localhost:8888/api/

     Weather by City ID
        http://localhost:8888/api/weather/1


# Running Unit tests using Junit and Mockito
### WeatherApplicationTest

1. Right-click on the `WeatherApplicationTest` class.
2. Select "Run 'WeatherApplicationTest'".

### WeatherControllerTest
1. Right-click on the `WeatherControllerTest` class.
2. Select "Run 'WeatherControllerTest'".

### WeatherServiceTest
1. Right-click on the `WeatherServiceTest` class.
2. Select "Run 'WeatherServiceTest'".

## Viewing Test Results

- IntelliJ IDEA will execute the tests and display the results in the "Run" tool window.
- Check the console output for any messages, 
- including test success or failure notifications.

## Troubleshooting

- **Dependency Issues**: Ensure all required dependencies are correctly 
                          configured in project.
- **Annotation Usage**: Double-check the usage of Mockito annotations 
                        (`@Mock`, `@InjectMocks`, etc.) in your test classes.
- **Console Output**: If tests fail, review the 
                      console output for error messages or exceptions.

## Conclusion

By following these steps, you can effectively run 
JUnit tests with Mockito for  Spring Boot application in IntelliJ IDEA.

## Additional Resources

- [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide/)
- [Mockito Documentation](https://site.mockito.org/)

# Running BDD Tests with Cucumber in IntelliJ IDEA

## Prerequisites

**Add Cucumber and RestAssured Dependencies**:
- Ensure Cucumber and RestAssured dependencies are included as dependencies in the
  project's build configuration (`pom.xml` for Maven ).

## Troubleshooting

- **Dependency Issues**: Ensure all required dependencies are correctly 
                          configured in the project.
- **Step Definitions**: Double-check the implementation of step definitions in 
                         Java classes.
- **Feature Files**:    Verify the correctness of feature files and scenarios defined.

## Conclusion

By following these steps, you can effectively run BDD tests with Cucumber 
for your Spring Boot application in IntelliJ IDEA.

## Additional Resources

- [Cucumber Documentation](https://cucumber.io/docs/guides/)
- [RestAssured Documentation](https://github.com/rest-assured/rest-assured/wiki/Usage)

# Continuous Integration with GitHub Actions

This repository utilizes GitHub Actions for continuous integration (CI) 
to automate the build, test, and Docker image creation process.

## CI Workflow Overview

The CI workflow defined in this repository performs the following steps:

1. **Checkout code**: The workflow checks out the code from the repository.

2. **Set up JDK**: It sets up the Java Development Kit (JDK) with version 17.

3. **Build with Maven**: The Maven build tool is used to package the application using 
                         the `pom.xml` file.

4. **Run JUnit tests**: The workflow executes JUnit tests to ensure code
                        quality and reliability.

5. **Run BDD tests**: BDD tests using Cucumber are run to verify 
                      the behavior of the application.

## Prerequisites

Before running the CI workflow, ensure the following prerequisites are met:

- Java 17 is installed.
- Maven is installed.
- Docker is installed.

## Running the CI Workflow

To run the CI workflow:

1. Push your changes to the `main; branch of the repository.

2. The workflow will automatically trigger on push to the `main` branch.

3. Monitor the workflow execution in the Actions tab of your GitHub repository.

4. Once the workflow completes successfully, review the build and test results 
    in the workflow logs.

## Conclusion

By using GitHub Actions for continuous integration, you can automate the build and test
process of your Java Spring Boot application, ensuring code quality and reliability.





