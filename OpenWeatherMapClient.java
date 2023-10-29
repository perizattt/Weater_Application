package com.example.practice10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;

public class OpenWeatherMapClient {
    private final String apiKey;

    public OpenWeatherMapClient(String apiKey) {
        this.apiKey = apiKey;
    }
    public WeatherDataOpenWeather getWeatherData(String city) {
        try {
            String apiUrl = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey;

            URL url = new URL(apiUrl);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();
                JSONObject json = new JSONObject(response.toString());
                double temperature = json.getJSONObject("main").getDouble("temp");
                String condition = json.getJSONArray("weather").getJSONObject(0).getString("description");
                WeatherDataOpenWeather weatherData = new WeatherDataOpenWeather(temperature);
                weatherData.setTemperature(temperature);
                weatherData.setCondition(condition);
                return weatherData;
            } else {
                throw new IOException("Error: " + responseCode);
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}