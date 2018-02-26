package com.open.micro.service.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.open.micro.service.BaseServiceTest;
import com.open.micro.service.dataaccess.dataobject.UserDo;

public class UserServiceTest extends BaseServiceTest{
	
	@Autowired private UserService userService;
	
	@Test
	public void testListAllUsers() {
		List<UserDo> userList = userService.listAllUsers(1, 10);
		Assert.assertNotNull( userList );
		Assert.assertTrue( userList.size() > 0 );
	}
	
}