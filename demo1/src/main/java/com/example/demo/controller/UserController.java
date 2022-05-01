package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.datainput.Input;
import com.example.demo.datainput.UserInfo;
import com.example.demo.datainput.UserMapper;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class UserController {

	
    @Autowired
    private UserMapper userMapper;
	
    @GetMapping("/user")
    public String hello(Model model) {
        return "user";
    }
    
    @RequestMapping("/regi")
    public String defectDetails(Model model) {
    	model.addAttribute(model);
        return "regi";
    }
    
    
    
    
    @PostMapping("/logined")
    public String loginCheck(HttpSession session,Input request,Model model) {
    	
    	String msg;
    	
    	int i = userMapper.doCheck(request);
    	
    	if(i< 1) {
    		msg= "ない";
    		 model.addAttribute("msg",msg);
    		return "user";
    	}else {
    		UserInfo userInfo =	userMapper.getUserInfo(request);
    		session.setAttribute("info", userInfo);
    		 model.addAttribute("userinfo",userInfo);
    		msg="OK";
    	}
    	 model.addAttribute("msg",msg);
    	
    	return "hello2";
    	
    }
    
    
    
    }