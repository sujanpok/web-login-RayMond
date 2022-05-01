package com.example.demo.service;

import org.springframework.ui.Model;

import com.example.demo.dataInput.Input;

public interface LoginService {

	String checklogin(Input request, Model model);

	void insertNewUser(Input userRequest);



	
		
	

	java.util.List<Input> getList();

	java.util.List<Input> searchAll();

	
}