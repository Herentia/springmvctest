package com.ssh.service;

import org.springframework.transaction.annotation.Transactional;

import com.ssh.entity.Person;

public interface PersonService {
	
	Long savePerson(Person person);

}
