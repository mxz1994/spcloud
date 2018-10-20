package com.mxz.hystrix;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableHystrixDashboard
@Controller
public class MxzhystrixdashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(MxzhystrixdashboardApplication.class, args);
	}
	
	@Value("${server.port}")
    String port;

	@RequestMapping("/")
    public String gohome() {
        return "forward:/hystrix";
    }
   
}
