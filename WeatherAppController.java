package com.example.practice10;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

public class WeatherAppController {
    @FXML
    private TextField locationInput;

    @FXML
    private ImageView weatherIcon;

    @FXML
    private Label temperature;

    @FXML
    private Label condition;

    @FXML
    private void searchWeather() {
        String apiKey = "36ea1dd540172273e8689c0c452e57b9";
        if (locationInput.getText().isEmpty()) {
            System.out.println("Location input is empty");
            return;
        }
        String city = locationInput.getText();
        OpenWeatherMapClient weatherClient = new OpenWeatherMapClient(apiKey);
        WeatherDataOpenWeather weatherData = weatherClient.getWeatherData(city);
        double a = 273.15;
        if (weatherData != null) {
            temperature.setText("" + (int) (weatherData.getTemperature() - a) + "°C");
            condition.setText("" + weatherData.getCondition());
        } else {
            System.out.println("Error");
        }
    }
}