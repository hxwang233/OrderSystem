package com.dao;

import com.bean.User;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserMapper {
	@Insert("insert into user (UserId,Account) values (#{userid},#{account})")
	int insert(User user);
	
	@Update("update user set Permission=2 where UserId=#{userid}")
	int deleteU(int userid);
	
	@Select("select * from user where UserID=#{userid}")
	User selectI(@Param("userid") int userid);
	
	@Select("select * from user where UserID=#{userid} and Password=#{password} and Permission=#{permission}")
    User selectUP(@Param("userid")int userid,@Param("password")String password,@Param("permission")int permission);
}