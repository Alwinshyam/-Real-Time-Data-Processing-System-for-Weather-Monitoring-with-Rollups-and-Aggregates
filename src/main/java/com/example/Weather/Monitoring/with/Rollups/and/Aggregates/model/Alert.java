package com.example.Weather.Monitoring.with.Rollups.and.Aggregates.model;

import java.time.LocalDateTime;

public class Alert {

    private String city;
    private String condition;
    private String message;
    private LocalDateTime alertTime;

    public Alert(String city, String condition, String message, LocalDateTime alertTime) {
        this.city = city;
        this.condition = condition;
        this.message = message;
        this.alertTime = alertTime;
    }

    // Getters and Setters

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getAlertTime() {
        return alertTime;
    }

    public void setAlertTime(LocalDateTime alertTime) {
        this.alertTime = alertTime;
    }
}

