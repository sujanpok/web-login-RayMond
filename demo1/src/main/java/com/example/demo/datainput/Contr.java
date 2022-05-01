package com.example.demo.datainput;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class Contr {

	
    @Autowired
    private UserMapper userMapper;
	
    @GetMapping("/user")
    public String hello(Model model) {
        return "user";
    }
    
    @RequestMapping("/regi")
    public String defectDetails() {
        return "regi";
    }
    
    
    
    
    @PostMapping("/logined")
    public String loginCheck(HttpSession session,Input request,Model model) {
    	
    	String msg;
    	
    	int i = userMapper.doCheck(request);
    	
    	if(i< 1) {
    		msg= "ない";
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

