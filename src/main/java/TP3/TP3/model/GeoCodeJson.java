package TP3.TP3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record GeoCodeJson(
        String type,
        String version,
        List<Features> features,
        String attribution,
        String licence,
        String query,
        String limit
) {

}
