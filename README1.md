# Spring Weather API

## Introduction

This project is a Spring Boot application that provides weather
information for various cities. It uses MySQL for data storage and 
follows a RESTful API architecture.

## Table of Contents

    - [Getting Started](#getting-started)
    - [Prerequisites](#prerequisites)
    - [Running the Application](#running-the-application)
    - [API Endpoints](#api-endpoints)
    - [Welcome](#welcome)
    - [Weather Information](#weather-information)
    - [Cities and Countries](#cities-and-countries)
    - [Weather by City ID](#weather-by-city-id)
    - [Data Storage](#data-storage)
    - [Build and Deployment](#build-and-deployment)
    - [Docker Configuration](#docker-configuration)

## Getting Started

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

    - Weather Information: 
         - http://localhost:8080/api/weatherinformation
    - Cities and Countries: 
         - http://localhost:8080/api/cities-and-countries
    - Welcome:
         - http://localhost:8080/api/
    - Weather by City ID (example):
         - http://localhost:8080/api/weather/1

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

## Data Storage

- The application uses MySQL for data storage. 
  Update application.properties with your MySQL configuration.

## Docker Configuration

To run the application using Docker, follow these steps:

1. Make sure you have Docker installed on your machine.
2. Navigate to the project directory
3. docker-compose build
4. docker-compose up -d
5.  docker-compose down

    Access the API :

    - Weather Information:
      http://localhost:8888/api/weatherinformation
    - Cities and Countries:
      http://localhost:8888/api/cities-and-countries
    - Welcome:
      http://localhost:8888/api/
    - Weather by City ID 
      http://localhost:8888/api/weather/1






