package com.jade.sbp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.jade.sbp.domain.User;

public interface UserMapper {
	@Select("select uname from User where uid=#{uid}")
	public String getUname(@Param("uid") String uid) throws Exception;
	
	public User getLoginInfo(@Param("uid") String uid) throws Exception;

	@Select("select * from User limit 100")
	public List<User> getUsers();
}
