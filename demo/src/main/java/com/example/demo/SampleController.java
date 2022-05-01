package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SampleController {
  // localhost:8080/
  

  @GetMapping("/object")
  public String getObject(Model model) {
    
    UserForm userForm = new UserForm();
    
    model.addAttribute("userForm", userForm);
    return "object";
  }

  @PostMapping("/object")
  public String postObject(UserForm userForm, BindingResult result, Model model) {
    if (result.hasErrors()) {
      
      return "object";
    }
    
    model.addAttribute("userForm", userForm);
   
    User user = makeUser(userForm);
    System.out.println(user.getId());
    System.out.println(user.getName());
    System.out.println(user.getEmail());
    System.out.println(user.getPassword());
    return "object-confirm";
  }
  
  private User makeUser(UserForm userForm) {
    User user = new User();
    user.setName(user.getName());
    user.setEmail(user.getEmail());
    user.setPassword(user.getPassword());
    return user;
  }

}