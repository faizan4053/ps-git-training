package com.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@EnableEurekaServer
@SpringBootApplication
public class NetflixeurekamicroservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(NetflixeurekamicroservicesApplication.class, args);
	}

}
