package com.mxz;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

import brave.sampler.Sampler;

@SpringBootApplication
//@EnableEurekaClient
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
	public ServletRegistrationBean getServlet(){

		HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
		ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
		registrationBean.setLoadOnStartup(1);  //系统启动时加载顺序
		registrationBean.addUrlMappings("/hystrix.stream");//路径
		registrationBean.setName("HystrixMetricsStreamServlet");
		return registrationBean;
	}


	 	@Bean
		public Sampler defaultSampler() {
			return Sampler.ALWAYS_SAMPLE;
		}

}
