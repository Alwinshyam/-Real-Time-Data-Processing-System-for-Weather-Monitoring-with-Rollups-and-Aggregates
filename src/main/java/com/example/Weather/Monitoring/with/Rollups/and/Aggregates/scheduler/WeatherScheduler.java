package com.example.Weather.Monitoring.with.Rollups.and.Aggregates.scheduler;

import com.example.Weather.Monitoring.with.Rollups.and.Aggregates.model.WeatherData;
import com.example.Weather.Monitoring.with.Rollups.and.Aggregates.repository.WeatherRepository;
import com.example.Weather.Monitoring.with.Rollups.and.Aggregates.service.WeatherService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherScheduler {

    private final WeatherService weatherService;
    private final WeatherRepository weatherRepository;

    public WeatherScheduler(WeatherService weatherService, WeatherRepository weatherRepository) {
        this.weatherService = weatherService;
        this.weatherRepository = weatherRepository;
    }

    @Scheduled(fixedRate = 300000)  // Every 5 minutes
    public void fetchWeatherData() {
        List<String> cities = List.of("Delhi", "Mumbai", "Chennai", "Bangalore", "Kolkata", "Hyderabad");
        cities.forEach(city -> {
            WeatherData weatherData = weatherService.getWeatherForCity(city);
            weatherRepository.save(weatherData);
        });
    }
}

