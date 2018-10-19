package com.mxz.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableHystrixDashboard
public class MxzhystrixdashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(MxzhystrixdashboardApplication.class, args);
	}
}
