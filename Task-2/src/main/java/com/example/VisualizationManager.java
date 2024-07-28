package com.example;
public class VisualizationManager {
    public void displaySummary(DailyWeatherSummary summary) {
        System.out.println("Average Temperature: " + summary.getAverageTemperature());
        System.out.println("Max Temperature: " + summary.getMaxTemperature());
        System.out.println("Min Temperature: " + summary.getMinTemperature());
    }
}
