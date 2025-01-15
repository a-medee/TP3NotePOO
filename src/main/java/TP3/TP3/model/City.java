package TP3.TP3.model;

public record City(
        String insee,
        int cp,
        String name,
        double latitude,
        double longitude,
        int altitude
) {}
