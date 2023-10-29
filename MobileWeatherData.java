package com.example.practice10;

public class MobileWeatherData {
    private double temperature;
    private String condition;

    public MobileWeatherData(double temperature){
        this.temperature=temperature;
    }
    public void setCondition(String condition) {
        this.condition = condition;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
}