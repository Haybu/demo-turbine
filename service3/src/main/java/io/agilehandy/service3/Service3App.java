package io.agilehandy.service3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@SpringBootApplication
@EnableCircuitBreaker
public class Service3App {

	public static void main(String[] args) {
		SpringApplication.run(Service3App.class, args);
	}
}
