package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dataInput.Input;
import com.example.demo.service.LoginService;

import lombok.extern.slf4j.Slf4j;

	@Controller
	@Slf4j
	public class Main {

	    @Autowired
	    private LoginService service;
		

		
	    @GetMapping("/userlogin")
	    public String hello(Model model) {
	        return "userlogin";
	    }
	    
	    @PostMapping("/logined")
	    public String loginCheck(Input request,Model model) {
	    	
	    	return service.checklogin(request,model);
	    
	    //return "hello2";
	    
	    	
	    }
	
	    @RequestMapping("/newregister")
	    public String defectDetails(@ModelAttribute("userRequest") Input input,Model model) {
	    	
	        return "newregister";
	    
	    }
	    @RequestMapping(value = "/userinformation", method = RequestMethod.POST)

	    public String create(@Validated @ModelAttribute Input userRequest, Model model) {
	        
	        service.insertNewUser(userRequest);
	       
	        List<Input> userList =  service.getList();
	        model.addAttribute("userinformation", userList);
	     
	       
	        return "/userinformation";
	        
	    }   
	        
	        
	        
	        
	    
	   
	    
	    }