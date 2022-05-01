//service

package com.example.demo;

import org.springframework.ui.Model;

public interface LoginService {

	String checklogin(Input request, Model model);
}