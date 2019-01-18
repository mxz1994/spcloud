package com.mxz.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@RestController
public class HelloController {

	@Autowired
	private DiscoveryClient discoveryClient;

	@ResponseBody
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
	
	@ResponseBody
	@GetMapping("/hello")
	public Object hello(HttpServletRequest request){
		 List<ServiceInstance> insList = discoveryClient.getInstances("eureka-server");
	        for (ServiceInstance si:insList) {
	            return si.getHost() +" ," + si.getServiceId() +"," +si.getPort() +"," +si.getUri() +"," +si.getMetadata();
	        }
		return "helasdlo2223s432"+request.getServerPort();
	    }
	
	@ResponseBody
	@GetMapping(value = {"/hello"}, params = "version")
	public Object hello2(HttpServletRequest request, String version){
		 List<ServiceInstance> insList = discoveryClient.getInstances("eureka-server");
	        for (ServiceInstance si:insList) {
	            return si.getHost() +" ," + si.getServiceId() +"," +si.getPort() +"," +si.getUri() +"," +si.getMetadata();
	        }
		return "hel123lo222"+request.getServerPort() + version;
	    }

	@ResponseBody
	@GetMapping(value = {"/hello33"})
	public Object hello3(HttpServletRequest request) throws IOException {
        BufferedReader reader = request.getReader();
        String str, wholeStr = "";
        while((str = reader.readLine()) != null) {
			wholeStr += str;
		}
		return false;
	}

}
