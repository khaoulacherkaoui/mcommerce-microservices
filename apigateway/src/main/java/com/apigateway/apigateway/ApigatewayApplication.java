package com.apigateway.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApigatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApigatewayApplication.class, args);
	}

	/*
	 * Dynamic routing locator using the eureka server
	 * */
	@Bean
	public RouteDefinitionLocator discoveryClientRouteDefinitionLocator(
			ReactiveDiscoveryClient discoveryClient, DiscoveryLocatorProperties properties
	) {
		return new DiscoveryClientRouteDefinitionLocator(discoveryClient, properties);
	}

	/*
	 * static routing to the other services
	 *

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("microservice-produits", r -> r.host("**.localhost:9004")
                        .and()
                        .path("/Produits/**")
                        .uri("http://localhost:9011/"))
/*
                .route("microservice-paiement",r -> r.host("**.localhost:9004")
                        .and()
                        .path("/**")
                        .filters(f -> f.prefixPath("/paiement"))
                        .uri("http://localhost:9003/"))
				.route("microservice-commandes",r -> r.host("**.localhost:9004")
						.and()
						.path("/**")
						.filters(f -> f.prefixPath("/commandes"))
						.uri("http://localhost:9002/"))*/
               // .build();
  //  }

}
