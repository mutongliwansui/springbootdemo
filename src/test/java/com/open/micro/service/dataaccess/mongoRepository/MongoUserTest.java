package com.open.micro.service.dataaccess.mongoRepository;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.open.micro.service.model.MongoUser;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MongoUserTest {
	
	@Autowired private MongoUserRepository mongoUserRepository;
	
	@Test
	public void testMongoDb() {
		MongoUser user = new MongoUser();
		user.setId(1L); user.setUserId("test1"); user.setUserName("test1");
		mongoUserRepository.save( user );
		user.setId(2L); user.setUserId("test2"); user.setUserName("test2");
		mongoUserRepository.save(user);
		Assert.assertEquals(2, mongoUserRepository.count());
		List<MongoUser> userList = mongoUserRepository.findAll();
		Assert.assertNotNull(userList);
		Assert.assertEquals(2, userList.size());
		Assert.assertEquals( "test2" , userList.get(1).getUserId());
		
	}

}
