package com.mxz.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Mxzeureka2Application {

	public static void main(String[] args) {
		SpringApplication.run(Mxzeureka2Application.class, args);
	}
}
