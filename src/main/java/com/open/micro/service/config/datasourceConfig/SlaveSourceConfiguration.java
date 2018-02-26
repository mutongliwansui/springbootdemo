package com.open.micro.service.config.datasourceConfig;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
public class SlaveSourceConfiguration {
	
	@Bean
	@ConfigurationProperties(prefix="spring.datasource.slave")
	public DataSource slaveDataSource() {
	    return DataSourceBuilder.create().type(DruidDataSource.class).build();
	}
	
	@Bean
	public DataSourceTransactionManager slaveTxManager( @Qualifier("slaveDataSource") DataSource slaveDataSource ) {
		return new DataSourceTransactionManager(slaveDataSource);
	}
	
}