package com.mxz.user.controller;

import com.mxz.user.model.User;
import com.mxz.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RefreshScope
@RequestMapping("user")
@RestController
public class UserController {
	
	//@Value("${foo}")
	private String foo;
	
	@Autowired
	private UserService userServiceImpl;
	
	@RequestMapping(value = "/hi")
	public String hi(@RequestParam(value = "v", required = false) String version, User user){
		
		return version + ":::" + user.toString();
	}

	@RequestMapping("/profile")
	public String profile() {
		return foo;
	}
	
	@PutMapping
	public void add(User user) {
		userServiceImpl.addUser(user);
	}
}
