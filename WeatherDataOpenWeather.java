package com.example.practice10;

public class WeatherDataOpenWeather {
    public double temperature;
    private String condition;

    public WeatherDataOpenWeather(double temperature) {
        this.temperature = temperature;
    }

    public WeatherDataOpenWeather() {
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public double getTemperature() {
        return temperature;
    }

    public String getCondition() {
        return condition;
    }
}