package com.example.Weather.Monitoring.with.Rollups.and.Aggregates.service;

import com.example.Weather.Monitoring.with.Rollups.and.Aggregates.model.WeatherData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    private final NotificationService notificationService;


    @Value("${openweathermap.api.key}")
    private String apiKey;

    @Value("${openweathermap.api.url}")
    private String apiUrl;

    private final RestTemplate restTemplate;

    public WeatherService(NotificationService notificationService, RestTemplate restTemplate) {
        this.notificationService = notificationService;
        this.restTemplate = restTemplate;
    }

    public WeatherData getWeatherForCity(String city) {
        String url = String.format("%s?q=%s&appid=%s", apiUrl, city, apiKey);
        ResponseEntity<WeatherApiResponse> response = restTemplate.getForEntity(url, WeatherApiResponse.class);
        return mapToWeatherData(response.getBody());
    }
    public WeatherService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void checkAndSendAlerts(WeatherData weatherData) {
        if (weatherData.getTemperature() > 40) {
            notificationService.notifyUsers(weatherData.getCity(), "High Temperature", weatherData.getTemperature());
        }
        if ("Storm".equalsIgnoreCase(weatherData.getMainCondition())) {
            notificationService.notifyUsers(weatherData.getCity(), "Storm Warning", 0);
        }
    }
}

    private WeatherData mapToWeatherData(WeatherApiResponse apiResponse) {
        // Map API response to WeatherData entity
    }
}

