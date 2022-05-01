package com.example.demo.datainput;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface  UserMapper {
	
	@Select(" select count(username) from hello where username = #{user} AND pwd = #{pwd}")
	int doCheck(Input user);

	
	@Select("select age, mail from userinfo where username = #{user}")
	UserInfo getUserInfo(Input request);
}
