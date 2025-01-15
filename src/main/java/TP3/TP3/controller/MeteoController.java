package TP3.TP3.controller;

import TP3.TP3.model.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import java.util.List;
import org.slf4j.LoggerFactory;

@Controller
public class MeteoController
{
    private static final String ETALAB_API = "https://api-adresse.data.gouv.fr/search/";
    private static final Logger log = LoggerFactory.getLogger(MeteoController.class);
    private String apiToken="15f15c6e2d1849cd6a60a7893e599814db1e1346b952174551f009664637b039";
    String apiUrl = "https://api.meteo-concept.com/api/forecast/daily?token=";

    @GetMapping("/meteo")
    @PostMapping
    public String showMeteo() {
        return "html/meteo";
    }

    @PostMapping("/meteo")
    public String displayWeather(@RequestParam("address") String address, Model model) {
        GeoCodeJson apiResult = getAddress(address);
        WeatherData weatherData = getWeatherByCityInsee(apiResult);

        List<Forecast> forecast = weatherData.forecast();
        City city = weatherData.city();
        String todayDate = weatherData.update();
        Forecast dayZero = forecast.getFirst();

        model.addAttribute("city", city);
        model.addAttribute("weatherData", weatherData);
        model.addAttribute("todayDate", todayDate);

        return "html/meteo";
    }

    public GeoCodeJson getAddress(String address)
    {

        String url = ETALAB_API + "?q=" + address.replace(" ", "+");

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<GeoCodeJson> responseEntity = restTemplate.getForEntity(url, GeoCodeJson.class);
        log.info(responseEntity.toString());
        return responseEntity.getBody();
    }

    public WeatherData getWeatherByCityInsee(GeoCodeJson apiResult)
    {
        Features firstFeature = apiResult.features().getFirst();
        Properties properties = firstFeature.properties();
        Geometry geometry = firstFeature.geometry();

        String cityCode = properties.citycode();
        String city = properties.city();
        String context = properties.context();
        List<Double> coordinates = geometry.coordinates();

        String apiURL = apiUrl + apiToken + "&insee=" + cityCode;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<WeatherData> weatherData = restTemplate.getForEntity(apiURL, WeatherData.class);

        return  weatherData.getBody();
    }
}
