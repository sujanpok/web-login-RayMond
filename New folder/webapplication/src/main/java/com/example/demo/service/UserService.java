package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dataInput.Input;
import com.example.demo.mapper.UserMapper;
@Service
public class UserService {
	
	 @Autowired
	    UserMapper mapper;
	//insert
	
    public void insertNewUser(Input request) {
    	 mapper.insertNewUser(request);
    }
    public List<Input> getList() {
        return mapper.find();
    }
}
