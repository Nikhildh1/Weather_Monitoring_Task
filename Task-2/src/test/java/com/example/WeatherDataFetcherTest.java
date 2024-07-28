package com.example;

import org.junit.Test;
import static org.junit.Assert.*;
import com.google.gson.JsonObject;
import java.io.IOException;

public class WeatherDataFetcherTest {

    @Test
    public void testGetWeatherData() {
        WeatherDataFetcher fetcher = new WeatherDataFetcher();
        try {
            JsonObject data = fetcher.getWeatherData("Delhi");
            assertNotNull("Weather data should not be null", data);
            assertTrue("Data should contain main object", data.has("main"));
        } catch (IOException e) {
            fail("IOException occurred: " + e.getMessage());
        }
    }
}
