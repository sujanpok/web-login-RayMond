package com.example.demo;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface  UserMapper {
	

	int doCheck(Input request);

	
	UserInfo getUserInfo(Input request);
}