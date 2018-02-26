package com.open.micro.service.config.datasourceConfig;

import com.open.micro.service.model.enums.DataSourceType;

public class DynamicDataSourceContextHolder {
	
	private static final ThreadLocal<DataSourceType> contextHolder = new ThreadLocal<DataSourceType>();
	
	public static void setDataSourceType(DataSourceType dataSourceType) {
		contextHolder.set(dataSourceType);
	}

	public static DataSourceType getDataSourceType() {
		DataSourceType dataSourceType = contextHolder.get();
		if ( null == dataSourceType ) {
			return DynamicDataSource.DEFAULT_DATASOURCE;
		}
		return dataSourceType;
	}

	public static void clearDataSourceType() {
		contextHolder.remove();
	}
}
