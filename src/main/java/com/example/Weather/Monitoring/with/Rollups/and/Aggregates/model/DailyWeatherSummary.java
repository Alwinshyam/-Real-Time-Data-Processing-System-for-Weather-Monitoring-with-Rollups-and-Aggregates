package com.example.Weather.Monitoring.with.Rollups.and.Aggregates.model;

import java.time.LocalDate;

public class DailyWeatherSummary {
    private String city;
    private LocalDate date;
    private double avgTemp;
    private double maxTemp;
    private double minTemp;
    private String dominantCondition;

    public DailyWeatherSummary(String city, LocalDate date, double avgTemp, double maxTemp, double minTemp, String dominantCondition) {

    }

    // Constructor, Getters, and Setters

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getAvgTemp() {
        return avgTemp;
    }

    public void setAvgTemp(double avgTemp) {
        this.avgTemp = avgTemp;
    }

    public double getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(double maxTemp) {
        this.maxTemp = maxTemp;
    }

    public double getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(double minTemp) {
        this.minTemp = minTemp;
    }

    public String getDominantCondition() {
        return dominantCondition;
    }

    public void setDominantCondition(String dominantCondition) {
        this.dominantCondition = dominantCondition;
    }
}

