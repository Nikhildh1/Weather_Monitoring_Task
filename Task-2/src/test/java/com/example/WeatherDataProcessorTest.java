package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class WeatherDataProcessorTest {

    @Test
    public void testKelvinToCelsius() {
        assertEquals(0, WeatherDataProcessor.kelvinToCelsius(273.15), 0.01);
        assertEquals(100, WeatherDataProcessor.kelvinToCelsius(373.15), 0.01);
        assertEquals(-273.15, WeatherDataProcessor.kelvinToCelsius(0), 0.01); // Absolute zero
    }
}
