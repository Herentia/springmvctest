package com.ssh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssh.dao.PersonRepository;
import com.ssh.entity.Person;

@Service
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	private PersonRepository personRepository;

	@Override
	public Long savePerson(Person p) {
		return personRepository.save(p);
	}

}
