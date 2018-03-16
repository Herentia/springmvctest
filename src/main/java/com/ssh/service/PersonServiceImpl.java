package com.ssh.service;

import com.ssh.dao.PersonRepository;
import com.ssh.entity.Person;
import com.ssh.service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author haohan
 *
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public int savePerson(Person person) {
        return personRepository.save(person);
    }

}