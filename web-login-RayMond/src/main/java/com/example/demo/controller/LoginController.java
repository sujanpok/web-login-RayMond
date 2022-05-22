package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dataInput.Input;
import com.example.demo.service.LoginService;

@Controller
public class LoginController {
	@Autowired
	private LoginService service;

//ログイン画面
	@GetMapping("")
	public String hello(Model model) {
		return "userlogin";
	}

//ログインチェック
	@PostMapping("/logined")
	public String loginCheck(Input request, Model model) {

		return service.checklogin(request, model);

	}

}