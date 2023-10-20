package com.fidelity.movil;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FidelityMovilApplication {

	public static void main(String[] args) {
		SpringApplication.run(FidelityMovilApplication.class, args);
	}

	@Bean
	public OpenAPI customOpenAPI(){
		return new OpenAPI()
				.info(new Info()
						.title("Fidelity Spring Boot 3 API")
						.version("0.1")
						.description("A description")
						.termsOfService("https://swagger.io/terms/")
						.license(new License().name("Apache 2.0").url("https://springdoc.org/")));
	}

}
