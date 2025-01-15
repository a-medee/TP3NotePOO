package TP3.TP3.controller;

import TP3.TP3.model.GeoCodeJson;
import TP3.TP3.model.Geometry;
import TP3.TP3.model.Features;
import TP3.TP3.model.Properties;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class MeteoController
{
    private static final String ETALAB_API = "https://api-adresse.data.gouv.fr/search/";
    private static final Logger log = LoggerFactory.getLogger(MeteoController.class);
    @GetMapping("/meteo")
    @PostMapping
    public String showMeteo() {
        return "html/meteo";
    }

//    @PostMapping("/meteo")
//    public String displayWeather(@RequestParam("address") String address, Model model) {
//
//        GeoCodeJson apiResult = getAddress(address);
//
//        model.addAttribute("apiResult", apiResult);
//
//        model.addAttribute("apiResultFeatures", apiResult.features());
//        model.addAttribute("apiResultFeaturesGeometry", apiResult.features()[0].geometry());
//        model.addAttribute("apiResultFeaturesType", apiResult.features()[0]);
//        model.addAttribute("apiResultFeaturesProperties", apiResult.features()[0]);
//        model.addAttribute("apiResultVersion", apiResult.version());
//        model.addAttribute("apiResultAttribution", apiResult.attribution());
//        model.addAttribute("apiResultLicence", apiResult.licence());
//        model.addAttribute("apiResultQuery", apiResult.query());
//        model.addAttribute("apiResultLimit", apiResult.limit());
//
//        return "html/meteo";
//    }

    @PostMapping("/meteo")
    public String displayWeather(@RequestParam("address") String address, Model model) {
        GeoCodeJson apiResult = getAddress(address);

        model.addAttribute("address", address);
        model.addAttribute("apiResult", apiResult);
        model.addAttribute("apiResultQuery", apiResult.query());

        if (apiResult.features() != null && !apiResult.features().isEmpty()) {
            Features firstFeature = apiResult.features().getFirst();
            model.addAttribute("apiResultFeatures", firstFeature);

            Geometry geometry = firstFeature.geometry();
            model.addAttribute("apiResultFeatureGeometry", geometry);
            model.addAttribute("longitude", geometry.coordinates().get(0));
            model.addAttribute("latitude", geometry.coordinates().get(1));

            Properties properties = firstFeature.properties();
            model.addAttribute("apiResultFeaturesProperties", properties);
            model.addAttribute("name", properties.name());
            model.addAttribute("label", properties.label());
            model.addAttribute("id", properties.id());
            model.addAttribute("oldcity", properties.oldCity());
            model.addAttribute("x", properties.x());
            model.addAttribute("y", properties.y());
            model.addAttribute("citycode", properties.citycode());
            model.addAttribute("score", properties.score());
            model.addAttribute("housenumber", properties.housenumber());
            model.addAttribute("street", properties.street());
            model.addAttribute("postcode", properties.postcode());
            model.addAttribute("city", properties.city());
            model.addAttribute("context", properties.context());
        }

        return "html/meteo";
    }

    public GeoCodeJson getAddress(String address) {

        String url = ETALAB_API + "?q=" + address.replace(" ", "+");

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<GeoCodeJson> responseEntity = restTemplate.getForEntity(url, GeoCodeJson.class);
        log.info(responseEntity.toString());
        return responseEntity.getBody();
    }
}
