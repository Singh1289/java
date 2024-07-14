package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.dao.UserRepository;
import com.app.model.User;

import jakarta.validation.Valid;

@Controller
public class MVCController {
	
	@Autowired
	UserRepository userRepository;

	@GetMapping("/")
	public String home()
	{
		System.out.println("Home....");
		return "index";
	}
	
	@GetMapping("/login")
	public String showForm(Model model)
	{
		System.out.println("Login");
		User user = new User();
		model.addAttribute("user", user);
		return "login_form";
	}
	
	@PostMapping("/loginUser")
	public String submitForm(@Valid @ModelAttribute("user")  User user, BindingResult result)
	{
		User u = null;
		if (result.hasErrors()) {
			return "login_form";
		}
		else
		{
		u = userRepository.validateUser(user.getEmail(), user.getPassword());
		}
		System.out.println(u);
		if(u == null)
			return "index";
		else
		return "login_success";
	}
}
