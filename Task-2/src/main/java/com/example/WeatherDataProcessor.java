package com.example;

import com.google.gson.JsonObject;

public class WeatherDataProcessor {

    public static double kelvinToCelsius(double kelvin) {
        return kelvin - 273.15;
    }

    public void processWeatherData(JsonObject weatherData) {
        double tempKelvin = weatherData.getAsJsonObject("main").get("temp").getAsDouble();
        double tempCelsius = kelvinToCelsius(tempKelvin);
        System.out.println("Temperature in Celsius: " + tempCelsius);
    }
}
