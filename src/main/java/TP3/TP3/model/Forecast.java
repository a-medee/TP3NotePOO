package TP3.TP3.model;

public record Forecast(
        String insee,
        int cp,
        double latitude,
        double longitude,
        int day,
        String datetime,
        int wind10m,
        int gust10m,
        int dirwind10m,
        double rr10,
        double rr1,
        int probarain,
        int weather,
        int tmin,
        int tmax,
        int sun_hours,
        int etp,
        int probafrost,
        int probafog,
        int probawind70,
        int probawind100,
        int gustx
) {}