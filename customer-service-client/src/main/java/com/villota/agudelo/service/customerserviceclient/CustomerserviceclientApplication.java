package com.villota.agudelo.service.customerserviceclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.villota.agudelo.service.customerserviceclient.config.CircuitBreakerConfiguration;
import com.villota.agudelo.service.customerserviceclient.config.WebClientConfiguration;

@SpringBootApplication
@Import({WebClientConfiguration.class, CircuitBreakerConfiguration.class})
public class CustomerserviceclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerserviceclientApplication.class, args);
	}
}
