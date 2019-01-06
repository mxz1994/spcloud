package com.mxz.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.mxz.zuul.getway.filter.AccessFilter;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class MxzZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(MxzZuulApplication.class, args);
	}
	
	@Bean
	public AccessFilter accessFilter() {
		return new AccessFilter();
	}
}
