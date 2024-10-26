package com.example.Weather.Monitoring.with.Rollups.and.Aggregates.service;

import com.example.Weather.Monitoring.with.Rollups.and.Aggregates.model.WeatherData;
import com.example.Weather.Monitoring.with.Rollups.and.Aggregates.repository.WeatherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlertService {

    private final WeatherRepository weatherRepository;

    public AlertService(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    public void checkForAlerts(String city) {
        List<WeatherData> latestData = weatherRepository.findTop2ByCityOrderByTimestampDesc(city);
        if (latestData.size() >= 2 && (latestData.get(0).getTemperature() > 35 && latestData.get(1).getTemperature() > 35)) {
            triggerAlert(city, latestData.get(0).getTemperature());
        }
    }

    private void triggerAlert(String city, double temperature) {
        System.out.printf("ALERT: High temperature detected in %s! Current temp: %.2f°C\n", city, temperature);
    }
}

