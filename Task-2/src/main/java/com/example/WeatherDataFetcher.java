package com.example;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;


public class WeatherDataFetcher {

    private static final String API_URL = loadConfig("api.url");
    private static final String API_KEY = loadConfig("api.key");

    private static String loadConfig(String key) {
        Properties properties = new Properties();
        try (InputStream input = WeatherDataFetcher.class.getClassLoader().getResourceAsStream("config.properties")) {
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

    public JsonObject getWeatherData(String city) throws IOException {
        String url = API_URL + "?q=" + city + "&appid=" + API_KEY;
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet request = new HttpGet(url);
        HttpResponse response = client.execute(request);
        String json = EntityUtils.toString(response.getEntity());
        client.close();

        Gson gson = new Gson();
        return gson.fromJson(json, JsonObject.class);
    }
}
