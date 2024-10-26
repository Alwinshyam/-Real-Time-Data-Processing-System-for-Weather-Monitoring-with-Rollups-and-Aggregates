# Real-Time Weather Monitoring with Rollups and Aggregates

## Overview
This project is a real-time weather data processing system that retrieves weather information from the OpenWeatherMap API and performs rollups and aggregates. It also triggers alerts when configurable weather thresholds are breached (e.g., temperature exceeds a certain value). The project is built using Spring Boot, MySQL for storage, and OpenWeatherMap API for weather data.

### Features:
- Real-time weather data retrieval from OpenWeatherMap API.
- Daily weather summaries: average, max, min temperatures, and dominant weather condition.
- User-configurable alerting thresholds for weather conditions (e.g., temperature exceeding a limit).
- Visualization and historical data support (in progress).
- API-based architecture to interact with different cities' weather data.

## Requirements
Before running the project, ensure that you have the following tools installed:

- Java 17 (or any compatible JDK version)
- Maven 3.6 or higher
- MySQL Database
- A free API key from [OpenWeatherMap](https://home.openweathermap.org/users/sign_up)
- Docker (Optional for setting up MySQL)

## Project Setup

### 1. Clone the repository

First, clone the repository from GitHub:

```bash
git clone https://github.com/Alwinshyam/Rule-Engine-with-AST-.git
cd Rule-Engine-with-AST-
2. OpenWeatherMap API Setup
Get your API key from OpenWeatherMap by signing up. Replace the placeholder <YOUR_API_KEY> in application.properties with your API key.

In the file src/main/resources/application.properties, update:

properties
Copy code
openweathermap.api.key=YOUR_OPENWEATHERMAP_API_KEY  # Replace with your actual API key
3. Database Setup
Option 1: Using Docker (Optional)
You can set up MySQL using Docker with the following command:

bash
Copy code
docker run --name weather-mysql -e MYSQL_ROOT_PASSWORD=Alwin#2001 -e MYSQL_DATABASE=weatherdb -p 3306:3306 -d mysql:8
This will set up a MySQL instance running on port 3306 with a database named weatherdb and the password as Alwin#2001.

Option 2: Using Local MySQL
If you already have MySQL installed, create the database manually:

sql
Copy code
CREATE DATABASE weatherdb;
4. Configure Database in application.properties
In src/main/resources/application.properties, configure your MySQL settings:

properties
Copy code
spring.datasource.url=jdbc:mysql://localhost:3306/weatherdb
spring.datasource.username=root
spring.datasource.password=Alwin#2001
5. Build and Run the Application
Using Maven
Open a terminal/command prompt in the root directory of the project.
Run the following Maven command to build the project:
bash
Copy code
mvn clean install
After the build completes, run the application:
bash
Copy code
mvn spring-boot:run
Running as a JAR
Alternatively, you can build a JAR file and run it:

bash
Copy code
mvn clean package
java -jar target/weather-monitoring-system-0.0.1-SNAPSHOT.jar
6. Verify Weather Data and Alerts
Once the application is running, it will start retrieving weather data for the specified Indian metros (Delhi, Mumbai, Chennai, Bangalore, Kolkata, Hyderabad) every 5 minutes.
Daily summaries will be generated and stored in the MySQL database.
Alerts will be triggered if the temperature exceeds the configured thresholds.
7. API Endpoints (for future extensions)
You can access endpoints (not implemented in this version) to:

View daily summaries.
Configure user-specific weather alerts.
View historical weather data trends.
Example Test Cases
1. Verify Weather Data Retrieval
Simulate API calls at configurable intervals to retrieve real-time weather data and verify the system correctly retrieves and parses the weather data.

2. Test Temperature Conversion
Ensure the temperature is converted correctly from Kelvin to Celsius or Fahrenheit, depending on user preference.

3. Verify Daily Summary Calculations
Test the roll-up logic to ensure correct calculation of average, minimum, and maximum temperatures for the day, along with the dominant weather condition.

4. Test Alerting System
Define temperature thresholds (e.g., above 35°C) and simulate weather data breaching the threshold to verify the alerting system.

Possible Extensions (Bonus)
Extend support for more weather parameters (humidity, wind speed, etc.).
Implement visualizations for daily summaries and alerts.
Add support for weather forecast data retrieval.
Author
This project is developed by Alwin Shyam.
