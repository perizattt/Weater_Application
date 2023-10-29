package com.example.practice10;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class WeatherApp extends Application {
    private TextField cityTextField;

    @Override
    public void start(Stage primaryStage) throws Exception {
        OpenWeatherMapClient weatherClient = new OpenWeatherMapClient("36ea1dd540172273e8689c0c452e57b9");
        WeatherDataAdapter adapter = new WeatherDataAdapter();

        cityTextField = new TextField();
        Button getWeatherButton = new Button("Search");
        getWeatherButton.setOnAction(event -> {
            String city = cityTextField.getText();
            WeatherDataOpenWeather openWeatherData = weatherClient.getWeatherData(city);
            MobileWeatherData mobileWeatherData = adapter.adaptFromOpenWeather(openWeatherData);

        });


        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        Scene scene = new Scene(root);

        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        primaryStage.setTitle("Weather App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}