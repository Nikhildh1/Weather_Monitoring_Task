package com.example;

import org.junit.Test;
import static org.junit.Assert.*;
import com.google.gson.JsonObject;
import java.io.IOException;

public class WeatherDataProcessingIntegrationTest {

    @Test
    public void testEndToEndProcessing() {
        WeatherDataFetcher fetcher = new WeatherDataFetcher();
        WeatherDataProcessor processor = new WeatherDataProcessor();
        WeatherDataStorage storage = new WeatherDataStorage();
        AlertManager alertManager = new AlertManager(35.0);

        try {
            JsonObject data = fetcher.getWeatherData("Delhi");
            double tempKelvin = data.getAsJsonObject("main").get("temp").getAsDouble();
            double tempCelsius = WeatherDataProcessor.kelvinToCelsius(tempKelvin);
            storage.addWeatherData("2024-07-27", tempCelsius);

            DailyWeatherSummary summary = storage.getDailySummary("2024-07-27");
            assertNotNull("Summary should not be null", summary);

            alertManager.checkForAlerts(tempCelsius);

        } catch (IOException e) {
            fail("IOException occurred: " + e.getMessage());
        }
    }
}

