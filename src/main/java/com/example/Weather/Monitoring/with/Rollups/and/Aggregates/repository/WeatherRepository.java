package com.example.Weather.Monitoring.with.Rollups.and.Aggregates.repository;

import com.example.Weather.Monitoring.with.Rollups.and.Aggregates.model.WeatherData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface WeatherRepository extends JpaRepository<WeatherData, Long> {
    List<WeatherData> findByCityAndDate(String city, LocalDate date);
    List<WeatherData> findTop2ByCityOrderByTimestampDesc(String city);
}

