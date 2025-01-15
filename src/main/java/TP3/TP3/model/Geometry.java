package TP3.TP3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Geometry(String type, List<Double> coordinates) {
}
