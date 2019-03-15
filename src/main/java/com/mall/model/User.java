package com.mall.model;

import java.io.Serializable;

public class User implements Serializable {
	//用户名
	private String userName;
	//密码
	private String password;
	//用户类型，只有“normal”和“admin”两种
	private String userType;
	//用户ID
	private Integer userId;
	//手机号码
	private String phone;
	//邮箱
	private String mail;

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

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
}
