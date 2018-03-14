package com.ssh.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssh.entity.Person;

@Repository
public class PersonRepositoryImpl implements PersonRepository {
	
	@Autowired
	private SessionFactory sessionfactory;
	
	private Session getSession() {
		return sessionfactory.getCurrentSession();
	}

	@Override
	public Person load(Long id) {
		return (Person) getSession().load(Person.class, id);
	}

	@Override
	public Person get(Long id) {
		return (Person) getSession().get(Person.class, id);
	}

	@Override
	public List<Person> findAll() {
		return null;
	}

	@Override
	public void persist(Person entity) {
		getSession().persist(entity);
	}

	@Override
	public Long save(Person entity) {
		return (Long) getSession().save(entity);
	}

	@Override
	public void saveOrUpdate(Person entity) {
		getSession().saveOrUpdate(entity);
	}

	@Override
	public void delete(Long id) {
		getSession().delete(id);
	}

	@Override
	public void flush() {
		getSession().flush();
	}

}
