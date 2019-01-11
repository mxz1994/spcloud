package com.mxz.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mxz.user.dao.UserDao;
import com.mxz.user.model.User;
import com.mxz.user.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	public UserDao userDao;
	
	public void addUser(User user) {
		userDao.save(user);
	}
}
