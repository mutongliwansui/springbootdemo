package com.open.micro.service.dataaccess;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import com.open.micro.service.BaseServiceTest;
import com.open.micro.service.dataaccess.dataobject.UserDo;

public class RedisTest extends BaseServiceTest{
	
	@Autowired private StringRedisTemplate stringRedisTemplate;
	@Autowired private RedisTemplate<String, Object> redisTemplate;
	
	@Test
	public void testRedisConfig() {
		
		ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
		ops.set("test", "value");
		Assert.assertEquals( "value" , ops.get("test"));
		Assert.assertNull( ops.get("test2") );
		
		ValueOperations<String, Object> ops2 = redisTemplate.opsForValue();
		UserDo userDo = new UserDo();
		userDo.setId(1L); userDo.setUserId("userId"); userDo.setUserName("userName");
		ops2.set("testUser", userDo);
		
		UserDo redisUser = (UserDo)ops2.get("testUser");
		Assert.assertNotNull( redisUser );
		
		Assert.assertTrue( 1L==redisUser.getId() );
		Assert.assertEquals("userId", redisUser.getUserId());
		Assert.assertEquals("userName", redisUser.getUserName());
		
	}
}
