package com.example.eurekaproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@EnableEurekaClient
@SpringBootApplication
public class EurekaProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaProducerApplication.class, args);
	}

}
