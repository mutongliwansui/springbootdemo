package com.open.micro.service.dataaccess.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.open.micro.service.dataaccess.dataobject.UserDo;


public interface UserDoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserDo record);

    int insertSelective(UserDo record);

    UserDo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserDo record);

    int updateByPrimaryKey(UserDo record);
    
    @Select("SELECT * FROM user")
    List<UserDo> listAllUsers();
}