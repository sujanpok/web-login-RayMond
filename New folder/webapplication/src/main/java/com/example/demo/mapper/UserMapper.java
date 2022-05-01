package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dataInput.Input;




@Mapper
public interface  UserMapper {
	

	int doCheck(Input request);

	 public void insertNewUser(Input userRequest);

	 Input getUserInfo(Input request);

	
	public List<Input> find();
	
	
	


	
}