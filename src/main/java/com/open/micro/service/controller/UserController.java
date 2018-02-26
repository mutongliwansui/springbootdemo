package com.open.micro.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.open.micro.service.dataaccess.dataobject.UserDo;
import com.open.micro.service.dataaccess.mongoRepository.MongoUserRepository;
import com.open.micro.service.model.MongoUser;
import com.open.micro.service.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired private UserService userService;
	@Autowired private MongoUserRepository mongoUserRepository;
	
	@RequestMapping("/list")
	public List<UserDo>  listAllUsers(
		@RequestParam(value="page", required=false) Integer page, 
		@RequestParam(value="pageSize", required=false) Integer pageSize
	){
		page = null==page?page=1:page;
		pageSize = null==pageSize||pageSize>100 ? pageSize= 10: pageSize;
		return this.userService.listAllUsers(page, pageSize);
	}
	
	@RequestMapping("/add")
	public void addUser(@RequestParam("userId") String userId, @RequestParam("userName") String userName){
		MongoUser user = new MongoUser();
		user.setId( this.mongoUserRepository.count() + 1 );
		user.setUserId(userId); user.setUserName(userName);
		this.mongoUserRepository.save( user );
	}
	
	@RequestMapping("/ll")
	public Object listUsers() {
		return this.mongoUserRepository.findAll();
	}
	
	
	
}