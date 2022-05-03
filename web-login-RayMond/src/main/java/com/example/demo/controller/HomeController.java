package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
	@GetMapping("/home")
	public String getHome(Model model) {
		// コンテンツ部分にユーザー詳細を表示するための文字列を登録
		model.addAttribute("contents", "login/home :: home_contents");
		return "login/home";
	}
//logout hello
	@PostMapping("/logout")
	public String postLogout() {
		return "redirect:/userlogin";
	}
}
