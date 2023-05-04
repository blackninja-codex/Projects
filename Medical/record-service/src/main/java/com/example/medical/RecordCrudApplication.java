package com.example.medical;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class RecordCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecordCrudApplication.class, args);
	}

}
