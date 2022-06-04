package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.demo.entity.NewUser;
import com.example.demo.service.UserService;

@Controller

public class UserController {

	@Autowired
	private UserService userService;

	// all list

	@GetMapping("newRegister")
	public String index(Model model) { // ②
		List<NewUser> register = userService.findAll();
		model.addAttribute("register", register); // ③
		return "newRegister/register"; // ④
	}

	
	// 新規登録ユーザー
	@GetMapping("newRegister/new")
    public String newPlayer(Model model) {
        return "newRegister/new";
    }
	@PostMapping("/newRegister")
	public String create(@ModelAttribute NewUser newUser) { // ⑥
		userService.save(newUser);
		return "redirect:./newRegister"; // ⑦
	}
	
	
	@GetMapping("newUser/edit/{id}")
    public String edit(@PathVariable int id, Model model ) { // ⑤
		Optional<NewUser> newUser = userService.findById(id);
        model.addAttribute("newUser", newUser);
        return "newRegister/edit";
    }
	//show
	 @GetMapping("ok/{id}")
	 public String show(@PathVariable int id,NewUser newUser, Model model ) { // ⑤
			Optional<NewUser> register = userService.findById(id);
	        model.addAttribute("newUser", register);
	        return "newRegister/show";
	    }
	
	//update
	@PutMapping("{id}")
    public String update(@PathVariable int id, @ModelAttribute NewUser newUser) {
		newUser.setId(id);
        userService.save(newUser);
        return "redirect:/new"; // ⑦
    }
	
	//delet
	 @DeleteMapping("{id}")
	    public String destroy(@PathVariable int id) {
		 userService.delete(id);
		return "redirect:./newRegister"; // ⑦
    }
	
}
