package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    
    @RequestMapping(value = "/user/add", method = RequestMethod.GET)
    public String displayAdd(Model model) {
        model.addAttribute("userRequest", new UserRequest());
        return "user/add";
    }

    
    @RequestMapping(value = "/user/create", method = RequestMethod.POST)
    public String create(@Validated @ModelAttribute UserRequest userRequest, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "user/add";
        }

        return "user/okey";
    }
}