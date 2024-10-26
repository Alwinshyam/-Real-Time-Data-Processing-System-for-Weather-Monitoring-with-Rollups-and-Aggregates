package com.example.Weather.Monitoring.with.Rollups.and.Aggregates.service;

import com.example.Weather.Monitoring.with.Rollups.and.Aggregates.model.Alert;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class NotificationService {

    public void sendAlert(Alert alert) {
        // Simulate sending alert (could be through email, SMS, etc.)
        System.out.println("Sending alert: " + alert.getMessage());
    }

    public void notifyUsers(String city, String condition, double value) {
        String message = String.format("Alert for %s: Condition - %s, Value - %.2f", city, condition, value);
        Alert alert = new Alert(city, condition, message, LocalDateTime.now());
        sendAlert(alert);
    }
}

