package com.example.Weather.Monitoring.with.Rollups.and.Aggregates.repository;

import com.example.Weather.Monitoring.with.Rollups.and.Aggregates.model.DailyWeatherSummary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface DailySummaryRepository extends JpaRepository<DailyWeatherSummary, Long> {
    List<DailyWeatherSummary> findByCityAndDate(String city, LocalDate date);
}

