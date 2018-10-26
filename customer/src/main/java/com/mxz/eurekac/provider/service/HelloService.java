package com.mxz.eurekac.provider.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import rx.Observable;

@Service
public class HelloService {

	@Autowired
	public RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "hiError")
	public String hello(String name) {
		return restTemplate.getForObject("http://S2/hello",String.class);
	}
	
	private String hiError(String name) {
		return "hi" + name +"sorry,error";
	}
	
	public Observable<User> getUserById(Long id) {
		
		return Observable.create(observer -> {
			User user = restTemplate.getForObject("http://S2/hello", User.class, id);
			observer.onNext(user);
			observer.onCompleted();
		});
	}
}
