package TP3.TP3.controller;

import TP3.TP3.model.WeatherData;
import org.springframework.stereotype.Controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class WeatherController {

    private String apiToken="15f15c6e2d1849cd6a60a7893e599814db1e1346b952174551f009664637b039";

    @GetMapping("/weather")
    public ResponseEntity<WeatherData> getWeatherByCityInsee(@RequestParam String insee) {
        String apiUrl = "https://api.meteo-concept.com/api/forecast/daily?token=" + apiToken + "&insee=" + insee;

        RestTemplate restTemplate = new RestTemplate();

        WeatherData weatherData = restTemplate.getForObject(apiUrl, WeatherData.class);
        return ResponseEntity.ok(weatherData);

    }
}
