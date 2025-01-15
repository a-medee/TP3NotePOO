package TP3.TP3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Properties(
        String label,
        String score,
        String housenumber,
        String id,
        String name,
        String postcode,
        String citycode,
        float x,
        float y,
        String city,
        String oldCity,
        String context,
        String importance,
        String street
) {
}
