package com.mxz.eurekac.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mxz.eurekac.user.model.User;


@RestController
public class HelloController {
	
	@Value("${foo}")
	private String foo;
	@Autowired
	private DiscoveryClient discoveryClient;    

	@GetMapping("/provider/discovery")
	public Object discovery(){
	        List<String> list = discoveryClient.getServices();
	        System.out.println(list);
	        List<ServiceInstance> insList = discoveryClient.getInstances("eureka-server");
	        for (ServiceInstance si:insList) {
	            System.out.println(si.getHost() +"," + si.getServiceId() +"," +si.getPort() +"," +si.getUri() +"," +si.getMetadata());
	        }
	        return this.discoveryClient;
	    }
	
	@GetMapping("/hello")
	public Object hello(){
		  List<ServiceInstance> insList = discoveryClient.getInstances("eureka-server");
	        for (ServiceInstance si:insList) {
	            return si.getHost() +" ," + si.getServiceId() +"," +si.getPort() +"," +si.getUri() +"," +si.getMetadata();
	        }
	        return "hello";
	    }
	
	@RequestMapping(value = "/hi")
	public String hi(@RequestParam(value = "v", required = false) String version, User user){
		
		return version + user.toString();
	}
}
