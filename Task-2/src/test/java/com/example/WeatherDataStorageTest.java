package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

    public class WeatherDataStorageTest {

    @Test
    public void testAddAndRetrieveWeatherData() {
        WeatherDataStorage storage = new WeatherDataStorage();
        storage.addWeatherData("2024-07-27", 30.0);
        storage.addWeatherData("2024-07-27", 35.0);
        storage.addWeatherData("2024-07-27", 25.0);

        DailyWeatherSummary summary = storage.getDailySummary("2024-07-27");
        assertNotNull("Summary should not be null", summary);
        assertEquals(30.0, summary.getAverageTemperature(), 0.1);
        assertEquals(35.0, summary.getMaxTemperature(), 0.1);
        assertEquals(25.0, summary.getMinTemperature(), 0.1);
    }
}
