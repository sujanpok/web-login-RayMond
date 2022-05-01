package com.example.demo.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.example.demo.dataInput.Input;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserMapper userMapper;

//insert
	
  

	@Override
	public String checklogin(Input request,Model model) {
 	int i = userMapper.doCheck(request);
 	String msg;
    	if(i< 1) {
    		msg= "まだ登録されていません　登録してください。";
    		 model.addAttribute("msg",msg);
    		return "userlogin";
    	}else {
    		Input userInfo =	userMapper.getUserInfo(request);
    		 model.addAttribute("userinfo",userInfo);
    		msg="登録完了しました";
    		
       	 model.addAttribute("Input",userInfo);
       	 model.addAttribute("msg",msg);
       	 return "hello2";
    	}
    	
	}
	@Override
	  public void insertNewUser(Input userRequest) {
	    	userMapper.insertNewUser(userRequest);
	    }
	 public List<Input> getList() {
	        return userMapper.find();
	}
	@Override
	public List<Input> searchAll() {
		// TODO 自動生成されたメソッド・スタブ
		return userMapper.find();
	}

	 



	



	
	
}