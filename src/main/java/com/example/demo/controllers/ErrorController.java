package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
class CrashController {

	@GetMapping("/error")
	@ResponseBody
	public String triggerException() {
		throw new RuntimeException(
				"Expected: Mine used this to showcase what " + "happens when an exception is thrown");
	}

}