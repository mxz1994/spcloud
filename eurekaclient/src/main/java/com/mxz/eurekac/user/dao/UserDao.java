package com.mxz.eurekac.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mxz.eurekac.user.model.User;

public interface UserDao extends JpaRepository<User, Integer>{

}
