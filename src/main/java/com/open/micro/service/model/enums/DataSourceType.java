package com.open.micro.service.model.enums;

public enum DataSourceType {
	PRIMARY("dataSource"), SLAVE("slaveDataSource"), READ_ONLY("readonlyDataSource");
	
	private String beanName;
	private DataSourceType(String dataSourceType) {
		this.beanName = dataSourceType;
	}
	
	@Override
	public String toString() {
		return this.beanName;
	}
	
	public String getType() {
		return this.beanName;
	}
	
}