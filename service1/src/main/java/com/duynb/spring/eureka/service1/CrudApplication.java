package com.duynb.spring.eureka.service1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CrudApplication{

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

}
