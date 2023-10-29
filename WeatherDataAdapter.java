package com.example.practice10;

public class WeatherDataAdapter implements WeatherData {
    private WeatherDataOpenWeather openWeatherData;
    private WeatherDataWeatherAPI weatherAPIData;

    public WeatherDataAdapter() {
        super();
    }

    @Override
    public double getTemperature() {
        if (openWeatherData != null) {
            return openWeatherData.getTemperature();
        } else if (weatherAPIData != null) {
            return weatherAPIData.getTemp();
        }
        return 0.0;
    }

    @Override
    public String getCondition() {
        if (openWeatherData != null) {
            return openWeatherData.getCondition();
        } else if (weatherAPIData != null) {
            return weatherAPIData.getCurrentCondition();
        }
        return "Unknown";
    }

    public MobileWeatherData adaptFromOpenWeather(WeatherDataOpenWeather openWeatherData) {
        MobileWeatherData mobileWeatherData = new MobileWeatherData(getTemperature());
        mobileWeatherData.setTemperature(openWeatherData.getTemperature());
        mobileWeatherData.setCondition(openWeatherData.getCondition());
        return mobileWeatherData;
    }
}