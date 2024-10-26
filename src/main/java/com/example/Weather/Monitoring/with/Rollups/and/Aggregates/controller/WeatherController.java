package com.example.Weather.Monitoring.with.Rollups.and.Aggregates.controller;

import com.example.Weather.Monitoring.with.Rollups.and.Aggregates.model.DailyWeatherSummary;
import com.example.Weather.Monitoring.with.Rollups.and.Aggregates.model.WeatherData;
import com.example.Weather.Monitoring.with.Rollups.and.Aggregates.service.WeatherRollupService;
import com.example.Weather.Monitoring.with.Rollups.and.Aggregates.service.WeatherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {

    private final WeatherService weatherService;
    private final WeatherRollupService weatherRollupService;

    public WeatherController(WeatherService weatherService, WeatherRollupService weatherRollupService) {
        this.weatherService = weatherService;
        this.weatherRollupService = weatherRollupService;
    }

    @GetMapping("/current/{city}")
    public WeatherData getCurrentWeather(@PathVariable String city) {
        return weatherService.getWeatherForCity(city);
    }

    @GetMapping("/daily-summary/{city}")
    public DailyWeatherSummary getDailySummary(@PathVariable String city) {
        return weatherRollupService.getDailySummary(city, LocalDate.now());
    }
}

