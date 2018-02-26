package com.open.micro.service.model;

public class User {

	private Long id;
	private String userId = "user id";
	private String userName = "user name test";

	public User() {
	}

	public User(String userId, String userName) {
		super();
		this.userId = userId;
		this.userName = userName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
