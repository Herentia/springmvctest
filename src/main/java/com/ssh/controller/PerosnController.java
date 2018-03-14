package com.ssh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssh.entity.Person;
import com.ssh.service.PersonService;

@Controller
public class PerosnController {
	
	@Autowired
	private PersonService personService;
	
	@RequestMapping("/saveperson")
	@ResponseBody
	public String savePerson() {
		Person p = new Person();
		p.setUsername("zhangsan");
		p.setAddress("sahnghai");
		p.setRemark("1234");
		personService.savePerson(p);
		return "success";
	}

}
