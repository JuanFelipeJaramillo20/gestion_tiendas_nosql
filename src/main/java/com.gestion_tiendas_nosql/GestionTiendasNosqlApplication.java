package com.gestion_tiendas_nosql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
@PropertySources({
		@PropertySource("classpath:application.properties"),
		@PropertySource("classpath:application_secret.properties")
})

public class GestionTiendasNosqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionTiendasNosqlApplication.class, args);
	}

}
