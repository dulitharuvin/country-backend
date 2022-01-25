package com.dulitha.country;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@EntityScan(basePackages = "com.dulitha.country.model")
public class CountryBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(CountryBackendApplication.class, args);
	}

}
