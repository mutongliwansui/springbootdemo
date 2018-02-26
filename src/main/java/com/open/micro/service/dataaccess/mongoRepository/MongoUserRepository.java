package com.open.micro.service.dataaccess.mongoRepository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.open.micro.service.model.MongoUser;

@Repository("mongoUserRepository")
public interface MongoUserRepository extends MongoRepository<MongoUser, Long>{
	
	MongoUser findByUserId(String userId);
	
}
