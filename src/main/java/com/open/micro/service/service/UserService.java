package com.open.micro.service.service;

import java.util.List;

import com.open.micro.service.dataaccess.dataobject.UserDo;
import com.open.micro.service.model.Result;

public interface UserService {

	List<UserDo> listAllUsers( Integer page, Integer pageSize );

	Result addUser(String userId, String userName);
}
