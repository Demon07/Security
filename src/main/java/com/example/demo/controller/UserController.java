package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.service.WebSecurityService;
/**
 * 
 * @author HPP
 *
 */
@Controller
public class UserController {
	
	@Autowired
	WebSecurityService  WebSecurityService;
	
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/")
	public String hello() {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
			    .getAuthentication()
			    .getPrincipal();
	/*	WebSecurityService.HelloAdmin();*/
		
	/*	WebSecurityService.roleAdmin();*/
		WebSecurityService.test3();
		System.out.println(userDetails.getUsername());
		return "hello";
	}
	
}
