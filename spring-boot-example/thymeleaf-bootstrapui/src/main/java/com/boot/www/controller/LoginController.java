package com.boot.www.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class LoginController {
	private static final Logger log =LoggerFactory.getLogger(LoginController.class);

	@PostMapping("login")
	public String login(String username,String password) {
		log.info("login success:{},{}",username,password);
		return "main";
	}
}
