package com.mxz.eurekac.provider.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {

	@Autowired
	public RestTemplate restTemplate;
	
	public String hello(String name) {
		return restTemplate.getForObject("http://SERVICE2/hello",String.class);
	}
}
