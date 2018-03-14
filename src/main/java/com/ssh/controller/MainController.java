package com.ssh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssh.service.TestService;

@Controller
public class MainController {
	
	@Autowired
	@Qualifier("ts")
	private TestService testService;
	
	@RequestMapping("/test")
	public String test() {
		System.out.println("≤‚ ‘");
		return "test";
	}
	
	@RequestMapping("/testservice")
	public String testService() {
		return testService.test();
	}

}
