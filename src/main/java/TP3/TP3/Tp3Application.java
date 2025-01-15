package TP3.TP3;

import TP3.TP3.model.GeoCodeJson;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class Tp3Application {

	private static final Logger log = LoggerFactory.getLogger(Tp3Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Tp3Application.class, args);
	}

}
