package com.open.micro.service.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.open.micro.service.config.datasourceConfig.TargetDataSource;
import com.open.micro.service.config.interceptors.TraceIdHelper;
import com.open.micro.service.dataaccess.dataobject.UserDo;
import com.open.micro.service.dataaccess.mapper.UserDoMapper;
import com.open.micro.service.model.Result;
import com.open.micro.service.model.enums.DataSourceType;
import com.open.micro.service.service.UserService;

@Service("userService")
@TargetDataSource(DataSourceType.PRIMARY)
public class UserServiceImpl implements UserService{
	
	private final static Logger LOGGER = LoggerFactory.getLogger( UserServiceImpl.class );
	
	@Autowired private UserDoMapper userDoMapper;
	
	@Override
	@TargetDataSource(DataSourceType.SLAVE)
	public List<UserDo> listAllUsers( Integer page, Integer pageSize ) {
		PageHelper.startPage(page, pageSize, "id desc");
		List<UserDo> result = this.userDoMapper.listAllUsers();
		PageInfo<UserDo> pageInfo = new PageInfo<>( result );
		LOGGER.info( "total:{}, page:{}, pageSize:{}, pages:{}, tarceId:{}", pageInfo.getTotal(), pageInfo.getPageNum(), pageInfo.getPageSize(), pageInfo.getPages(), TraceIdHelper.getTraceId());
		return result;
	}
	
	@Override
	public Result addUser(String userId, String userName) {
		UserDo record = new UserDo();
		record.setUserId(userId);
		record.setUserName(userName);
		this.userDoMapper.insert(record);
		return Result.createSuccess();
	}
	
}
