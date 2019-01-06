package com.mxz.eurekac.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mxz.eurekac.user.model.User;
import com.mxz.eurekac.user.service.UserService;


@RestController
@RequestMapping("/user")
public class UserController {
	
	@Value("${foo:'a'}")
	private String foo;
	
	@Autowired
	private UserService userServiceImpl;
	
	@RequestMapping(value = "/hi")
	public String hi(@RequestParam(value = "v", required = false) String version, User user){
		
		return version + user.toString();
	}
	
	@PutMapping
	public void add(User user) {
		userServiceImpl.addUser(user);
	}
}
