package com.mxz.eurekac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.mxz.rule.MyRule;
import com.netflix.loadbalancer.BestAvailableRule;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

import brave.sampler.Sampler;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableHystrix
// 指定服务采用什么规则访问
//@RibbonClient(name = "MICROSERVICECLOUD-DEPT",configuration = MyRule.class)
@EnableFeignClients
public class RibonFegionHystrixApplication {

	public static void main(String[] args) {
		SpringApplication.run(RibonFegionHystrixApplication.class, args);
	}
	
	 	@Bean
	    @LoadBalanced
	   public RestTemplate restTemplate() {
	        return new RestTemplate();
	   }
	 	
	 	
	 	//配置负载均衡规则
	 	@Bean
	 	public IRule myRule() {
	 		return new RandomRule();
	 		//return new BestAvailableRule();
	 	}
	 	
	 	
	 	@Bean
		public Sampler defaultSampler() {
			return Sampler.ALWAYS_SAMPLE;
		}

}
