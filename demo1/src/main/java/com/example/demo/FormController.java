package com.example.demo;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FormController {
    @RequestMapping("/form")
    public String form(Model model){
       
        User user = new User();
        user.setName("");
        user.getSele();
        user.setMyColors(new String[]{"red","white", "black", "green",  "blue"});
        model.addAttribute("user", user);
        return "form";
    }

    @PostMapping("/submit")
    public String submit(@ModelAttribute User user, Model model){
       
        model.addAttribute("user", user);
        System.out.println("Full name:" + user.getName());
        System.out.println("Gender:" + user.getSele());
        System.out.println("Favorite colors:" + Arrays.toString(user.getMyColors()));
       
        return "submit";
    }

    
}