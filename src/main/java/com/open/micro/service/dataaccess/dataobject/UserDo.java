package com.open.micro.service.dataaccess.dataobject;

import java.io.Serializable;

public class UserDo implements Serializable {
    
	private static final long serialVersionUID = 2496328554621284867L;

	private Long id;

    private String userId;

    private String userName;

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
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }
}