# Use an official OpenJDK runtime as a base image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the packaged JAR file into the container
COPY target/spring-weather-api-amrita123sabat-1.0-SNAPSHOT.jar /app/

# Expose the port your app runs on
EXPOSE 8080

# Specify the command to run on container startup
CMD ["java", "-jar", "spring-weather-api-amrita123sabat-1.0-SNAPSHOT.jar"]
