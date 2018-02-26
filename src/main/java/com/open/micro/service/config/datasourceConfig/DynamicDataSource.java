package com.open.micro.service.config.datasourceConfig;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;

import com.open.micro.service.config.interceptors.TraceIdHelper;
import com.open.micro.service.model.enums.DataSourceType;

@Component
@AutoConfigureAfter(value={PrimarySourceConfiguration.class, SlaveSourceConfiguration.class, ReadonlySourceConfiguration.class})
public class DynamicDataSource extends AbstractRoutingDataSource{
	
	private static final Logger LOGGER = LoggerFactory.getLogger( DynamicDataSource.class );
	
	@Autowired private Map<String, DataSource> targetDataSources;
	
	public static DataSourceType DEFAULT_DATASOURCE = DataSourceType.PRIMARY;
	
	@PostConstruct
	public void setUpTargetDataSources() {
		Iterator<String> keyIte = targetDataSources.keySet().iterator();
		Map<Object, Object> dataSources =  new HashMap<>();
		while (keyIte.hasNext()) {
			String key = keyIte.next();
			dataSources.put(key, targetDataSources.get(key));
		}
//		setDefaultTargetDataSource( DynamicDataSource.DEFAULT_DATASOURCE.toString() );
		this.setTargetDataSources(dataSources);
	}
	
	@Override
	protected Object determineCurrentLookupKey() {
		String dataSource_beanName = DynamicDataSourceContextHolder.getDataSourceType().toString();
		LOGGER.debug( "traceId:{}, dataSource:{}", TraceIdHelper.getTraceId(), dataSource_beanName );
		return dataSource_beanName;
	}
	
}