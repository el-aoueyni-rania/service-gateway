package com.iset;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ServiceGateway1Application {

	public static void main(String[] args) {
		SpringApplication.run(ServiceGateway1Application.class, args);
	}

	@Bean
	 RouteLocator routes(RouteLocatorBuilder builder) { 
	 return builder.routes()
			 .route(r -> r.path("/societes/**").uri("http://localhost:8081"))
	         .route(r ->  r.path("/books/**").uri("http://localhost:8089"))
	         // gateway sts
	         .route(r ->  r.path("/users/**").uri("http://localhost:8082"))
	         .route(r ->  r.path("/activites/**").uri("http://localhost:8082"))
	         .route(r ->  r.path("/reservations/**").uri("http://localhost:8082"))
	         // gateway express
	         .route(r ->  r.path("/user/**").uri("http://localhost:8084"))
	         .route(r ->  r.path("/activite/**").uri("http://localhost:8084"))
	         .route(r ->  r.path("/reservation/**").uri("http://localhost:8084"))

	         .build();
	 }
}
