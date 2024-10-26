package com.example.Weather.Monitoring.with.Rollups.and.Aggregates.service;

import com.example.Weather.Monitoring.with.Rollups.and.Aggregates.model.DailyWeatherSummary;
import com.example.Weather.Monitoring.with.Rollups.and.Aggregates.model.WeatherData;
import com.example.Weather.Monitoring.with.Rollups.and.Aggregates.repository.WeatherRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class WeatherRollupService {

    private final WeatherRepository weatherRepository;

    public WeatherRollupService(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    public DailyWeatherSummary getDailySummary(String city, LocalDate date) {
        List<WeatherData> weatherDataList = weatherRepository.findByCityAndDate(city, date);
        double avgTemp = weatherDataList.stream().mapToDouble(WeatherData::getTemperature).average().orElse(0);
        double maxTemp = weatherDataList.stream().mapToDouble(WeatherData::getTemperature).max().orElse(0);
        double minTemp = weatherDataList.stream().mapToDouble(WeatherData::getTemperature).min().orElse(0);
        String dominantCondition = calculateDominantCondition(weatherDataList);

        return new DailyWeatherSummary(city, date, avgTemp, maxTemp, minTemp, dominantCondition);
    }

    private String calculateDominantCondition(List<WeatherData> weatherDataList) {
        return weatherDataList.stream()
                .collect(Collectors.groupingBy(WeatherData::getMainCondition, Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();
    }
}

