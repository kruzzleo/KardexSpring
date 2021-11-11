package com.todo1.kardexSpring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutController {

	@GetMapping("/logout/backSoon")
	public String backSoon() {
		return "backSoon";
	}
}
