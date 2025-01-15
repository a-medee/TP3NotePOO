package TP3.TP3.model;

import java.util.List;

public record WeatherData(
        City city,
        String update,
        List<Forecast> forecast
) {}