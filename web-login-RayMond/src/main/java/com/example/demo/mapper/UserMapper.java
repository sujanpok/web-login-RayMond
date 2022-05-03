package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dataInput.Input;

@Mapper
public interface UserMapper {
	int doCheck(Input request);

}