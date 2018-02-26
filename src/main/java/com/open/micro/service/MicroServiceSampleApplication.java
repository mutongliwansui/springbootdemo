package com.open.micro.service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableAspectJAutoProxy
@MapperScan("com.open.micro.service.dataaccess.mapper")
//@EnableDiscoveryClient
public class MicroServiceSampleApplication implements CommandLineRunner{
	
	public static void main(String[] args) {
		SpringApplication.run(MicroServiceSampleApplication.class, args);
	}
	
	@Override
	public void run(String... arg0) throws Exception {
	}
	
}