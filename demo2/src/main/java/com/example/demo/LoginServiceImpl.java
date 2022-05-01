//serivice/servicempl
package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserMapper userMapper;



	@Override
	public String checklogin(Input request,Model model) {
 	int i = userMapper.doCheck(request);
 	String msg;
    	if(i< 1) {
    		msg= "ない";
    	}else {
    		UserInfo userInfo =	userMapper.getUserInfo(request);
    		 model.addAttribute("userinfo",userInfo);
    		msg="OK";
    	}
		
    	 model.addAttribute("msg",msg);
		return msg;
	}
	
}