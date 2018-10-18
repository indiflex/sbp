package com.jade.sbp.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.jade.sbp.domain.User;

public interface UserMapper {
	@Select("select * from User where uid=#{uid}")
	public User getLoginInfo(@Param("uid") String uid) throws Exception;
}
