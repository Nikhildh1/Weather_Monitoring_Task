package com.example;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;
import com.google.gson.JsonObject;

public class WeatherDataScheduler {

    private Timer timer = new Timer();
    private WeatherDataFetcher fetcher = new WeatherDataFetcher();
    private WeatherDataProcessor processor = new WeatherDataProcessor();

    public void start() {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    JsonObject weatherData = fetcher.getWeatherData("Delhi");
                    processor.processWeatherData(weatherData);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, 0, Long.parseLong(loadConfig("update.interval")));
    }

    private String loadConfig(String key) {
        Properties properties = new Properties();
        try (InputStream input = WeatherDataScheduler.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                return null;
            }
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return properties.getProperty(key);
    }

    public static void main(String[] args) {
        WeatherDataScheduler scheduler = new WeatherDataScheduler();
        scheduler.start();
    }
}
