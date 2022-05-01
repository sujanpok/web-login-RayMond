

package com.example.demo;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.input.Input;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("message", "Hello Thymeleaf!!");
        return "hello";
    }
    @GetMapping("/hello2")
    public String hello2(@ModelAttribute Input form, Model model){
        form.getFname();
        form.getLname();
        System.out.println(form.getFname());
        System.out.println(form.getLname());
        
        model.addAttribute("form", form);
        return "hello2";
    }
}