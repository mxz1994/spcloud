package com.mxz.eurekac.user.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.mxz.eurekac.base.model.BaseVO;

@Entity
public class User extends BaseVO{
	
	private static final long serialVersionUID = 1L;

	@Column(name="USER_NAME")
	private String userName;
	
	@Column(name="PASSWORD")
	private String password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
