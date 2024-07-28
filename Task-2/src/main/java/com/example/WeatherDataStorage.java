package com.example;

import java.util.HashMap;
import java.util.Map;

public class WeatherDataStorage {
    private Map<String, DailyWeatherSummary> dailySummaries = new HashMap<>();

    public void addWeatherData(String date, double temperature) {
        DailyWeatherSummary summary = dailySummaries.getOrDefault(date, new DailyWeatherSummary());
        summary.addTemperature(temperature);
        dailySummaries.put(date, summary);
    }

    public DailyWeatherSummary getDailySummary(String date) {
        return dailySummaries.get(date);
    }
}

class DailyWeatherSummary {
    private double totalTemp = 0;
    private double maxTemp = Double.MIN_VALUE;
    private double minTemp = Double.MAX_VALUE;
    private int count = 0;

    public void addTemperature(double temp) {
        totalTemp += temp;
        if (temp > maxTemp) maxTemp = temp;
        if (temp < minTemp) minTemp = temp;
        count++;
    }

    public double getAverageTemperature() {
        return totalTemp / count;
    }

    public double getMaxTemperature() {
        return maxTemp;
    }

    public double getMinTemperature() {
        return minTemp;
    }

    // Add method for determining dominant weather condition
}
