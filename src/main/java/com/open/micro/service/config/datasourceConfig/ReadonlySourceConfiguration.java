package com.open.micro.service.config.datasourceConfig;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
@AutoConfigureAfter(SlaveSourceConfiguration.class)
public class ReadonlySourceConfiguration {
	
	@Bean
	@ConfigurationProperties(prefix="spring.datasource.readonly")
	public DataSource readonlyDataSource() throws SQLException {
		DruidDataSource dataSource = (DruidDataSource)DataSourceBuilder
					.create()
					.type(DruidDataSource.class)
					.build();
//		dataSource.setFilters("wall");
		/*
		WallFilter wallFilter = new WallFilter();
		wallFilter.setLogViolation(true);
		wallFilter.setThrowException(false);
		dataSource.getProxyFilters().add(wallFilter);
		*/
	    return dataSource;
	}
	
	@Bean
	public DataSourceTransactionManager readonlyTxManager( @Qualifier("readonlyDataSource") DataSource readonlyDataSource ) {
		return new DataSourceTransactionManager(readonlyDataSource);
	}
}
