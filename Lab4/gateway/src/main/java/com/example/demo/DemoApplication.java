package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication()
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public RouteLocator routeLocator(
			RouteLocatorBuilder builder,
			@Value("${fifa.player.url}") String playerUrl,
			@Value("${fifa.club.url}") String clubUrl,
			@Value("${fifa.gateway.host}") String host
	) {
		return builder
				.routes()
				.route("players", route -> route
						.host(host)
						.and()
						.path(
								"/api/players/{uuid}",
								"/api/players"
						)
						.uri(playerUrl)
				)
				.route("clubs", route -> route
						.host(host)
						.and()
						.path(
								"/api/clubs/{uuid}",
								"/api/clubs"
						)
						.uri(clubUrl)
				)
				.build();
	}

}
